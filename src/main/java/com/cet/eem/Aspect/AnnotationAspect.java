package com.cet.eem.Aspect;

import com.cet.eem.annotation.MyFieldAnnotation;
import com.cet.eem.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author yucan
 * @date 2022/10/12 10:40
 */
@Slf4j
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class AnnotationAspect {
    @Pointcut("@annotation(com.cet.eem.annotation.MyMethodAnnotation)")
    public void annotationPointCut() {
    }

    @AfterReturning(returning = "ret", pointcut = "annotationPointCut()")
    public void afterReturn(Object ret) throws Exception {
        if (ret instanceof Collection) {
            Iterator iterator = ((Collection<?>) ret).iterator();
            while (iterator.hasNext()) {
                afterReturn(iterator.next());
            }
        } else {
            doObjectMethod(ret);
        }
    }

    //针对对象进行国际化操作
    public void doObjectMethod(Object ret) {
        try {
            //通过getDeclaredFields()方法获取对象类中的所有属性（含私有）
            Field[] fields = ret.getClass().getDeclaredFields();
            for (Field field : fields) {
                boolean hasSecureField = field.isAnnotationPresent(MyFieldAnnotation.class);
                //判断有没有加过注解的字段
                if (hasSecureField) {
                    //设置允许通过反射访问私有变量
                    field.setAccessible(true);
                    //获取字段的值
                    String value = field.get(ret).toString();
                    //获取字段属性名称
                    String name = field.getName();
                    //国际化
                    setValue(ret, name, MessageUtil.getMessage(value));
                }
            }
        } catch (Exception ex) {
            //处理异常
            ex.printStackTrace();
        }
    }

    /**
     * 动态get对象属性的value值
     */
    private void setValue(Object dto, String name, Object value) {
        try {
            Method[] m = dto.getClass().getMethods();
            for (int i = 0; i < m.length; i++) {
                if (("set" + name).toLowerCase().equals(m[i].getName().toLowerCase())) {
                    m[i].invoke(dto, value);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

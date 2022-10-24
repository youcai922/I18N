package com.cet.eem.config;

import com.cet.eem.entity.Result;
import com.cet.eem.util.MessageUtil;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author yucan
 * @date 2022/10/13 14:54
 */
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    /**
     * 判断是否执行beforeBodyWrite方法的Controller，返回true表示执行，false表示不执行
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    /**
     * 对返回值进行加工处理
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        try {
            if (body instanceof Result && ((Result<?>) body).getMsg() != null) {
                ((Result<?>) body).setMsg(MessageUtil.getMessage(((Result<?>) body).getMsg()));
            }
        } catch (NoSuchMessageException exception) {
            return body;
        }
        return body;
    }
}
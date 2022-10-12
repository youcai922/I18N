package com.cet.eem.util;

import com.cet.eem.enums.MessageEnum;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName MessageUtil
 * @Description 实质消息获取类
 * @Author yucan
 **/
@Component
public class MessageUtil {

    @Resource
    private MessageSource messageSource;

    private static MessageSource staticMessageSource;

    @PostConstruct
    public void init() {
        MessageUtil.staticMessageSource = messageSource;
    }

    /**
     * 转化当前信息为用户当前的信息
     *
     * @param messageEnum 需要转化的key值
     * @param args        参数
     */
    public static String getMessage(MessageEnum messageEnum, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        try{
            return staticMessageSource.getMessage(messageEnum.getKey(), args, locale);
        }catch (NoSuchMessageException ex){
            return messageEnum.getKey();
        }
    }

    public static String getMessage(String messageEnumKey) {
        Locale locale = LocaleContextHolder.getLocale();
        try{
            return staticMessageSource.getMessage(messageEnumKey, null, locale);
        }catch (NoSuchMessageException ex){
            return messageEnumKey;
        }
    }

    /**
     * 时间格式化
     *
     * @param date 时间
     */
    public static String formatDate(Date date) {
        Locale locale = LocaleContextHolder.getLocale();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return df1.format(date);
    }
}
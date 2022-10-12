package com.cet.eem.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @ClassName MyLocaleResolverConfig
 * @Description 自定义本地国际化，实现LocalResolver接口，默认的解析器，用于设置当前会话的默认国际化语言
 * @Author yucan
 **/
public class MyLocaleResolverConfig implements LocaleResolver {

    private static final String PATH_PARAMETER = "lang";

    private static final String PATH_PARAMETER_SPLIT = "_";

    private static final String LANG_SESSION = "lang_session";

    /**
     * 根据request对象根据指定的方式获取一个Locale，如果没有获取到，则使用用户指定的默认的Locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getHeader(PATH_PARAMETER);
        Locale locale = request.getLocale();
        if (StringUtils.isNotBlank(lang)) {
            String[] split = lang.split(PATH_PARAMETER_SPLIT);
            locale = new Locale(split[0], split[1]);

            HttpSession session = request.getSession();
            session.setAttribute(LANG_SESSION, locale);

            //30秒钟有效期
            session.setMaxInactiveInterval(30);
        } else {
            HttpSession session = request.getSession();
            Locale localeInSession = (Locale) session.getAttribute(LANG_SESSION);
            if (localeInSession != null) {
                locale = localeInSession;
            }
        }
        return locale;
    }

    /**
     * 用于实现Locale的切换。比如SessionLocaleResolver获取Locale的方式是从session中读取，但如果用户想要切换其展示的样式(由英文切换为中文)，那么这里的setLocale()方法就提供了这样一种可能
     */
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
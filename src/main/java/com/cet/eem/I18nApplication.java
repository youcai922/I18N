package com.cet.eem;

import com.cet.eem.config.MyLocaleResolverConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.LocaleResolver;

@EnableCaching
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.cet.*.**")
public class I18nApplication {

    public static void main(String[] args) {
        SpringApplication.run(I18nApplication.class, args);
    }

    //将我们自定义的 MyLocaleResolverConfig 作为 Bean 注册进系统中
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolverConfig();
    }
}
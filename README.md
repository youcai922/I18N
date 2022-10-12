# I18N
SpringBoot 国际化 i18n



#### 项目介绍

项目利用自定义注解是实现了对某个Service层的返回值的某个字段进行国际化翻译的功能

- 项目支持对类的指定字段进行翻译
- 支持多语言，多翻译配置文件



PS：原本用的是公司的Result类，但是我去掉Result类之后就错误了

```java
No MethodInvocation found: Check that an AOP invocation is in progress and that the ExposeInvocationInterceptor is upfront in the interceptor chain. Specifically, note that advices with order HIGHEST_PRECEDENCE will execute before ExposeInvocationInterceptor! In addition, ExposeInvocationInterceptor and ExposeInvocationInterceptor.currentInvocation() must be invoked from the same thread.
```

好像是切面错误了，有时间再看看

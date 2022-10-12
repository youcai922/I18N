package com.cet.eem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageEnum {

    HELLO("hello"),
    I18N("i18n"),
    GASCOMPRESSOR("gascompressor"),
    CHINESE_TEST("中文测试"),
    ;
    private String key;
}
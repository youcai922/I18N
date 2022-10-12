package com.cet.eem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yucan
 * @date 2022/10/12 9:42
 */
@Getter
@AllArgsConstructor
public enum MessageDesEnum {

    HELLO("hello", "你好"),
    I18N("i18n", "国际化"),
    GASCOMPRESSOR("gascompressor", "天然气压缩机"),
    ;
    private String key;
    private String description;
}
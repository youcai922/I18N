package com.cet.eem.entity.VO;


import com.cet.eem.annotation.MyFieldAnnotation;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author yucan
 */
@Getter
@Setter
@Accessors(chain = true)
public class GasCompressorRealTimeDataVo {

    @MyFieldAnnotation
    private String gascompressorName;

    private String test;

    private String test1;
}
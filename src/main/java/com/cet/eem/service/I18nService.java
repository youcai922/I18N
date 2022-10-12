package com.cet.eem.service;

import com.cet.eem.annotation.MyMethodAnnotation;
import com.cet.eem.entity.VO.GasCompressorRealTimeDataVo;
import com.cet.eem.enums.MessageDesEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author yucan
 */
@Service
public class I18nService {
    @MyMethodAnnotation
    public GasCompressorRealTimeDataVo realtimedata() {
        GasCompressorRealTimeDataVo gasCompressorRealTimeDataVo = new GasCompressorRealTimeDataVo();
        gasCompressorRealTimeDataVo.setGascompressorName(MessageDesEnum.GASCOMPRESSOR.getKey());
        gasCompressorRealTimeDataVo.setTest("中文测试");
        gasCompressorRealTimeDataVo.setTest1("不包含测试");
        return gasCompressorRealTimeDataVo;
    }

    public GasCompressorRealTimeDataVo realtimedata2() {
        GasCompressorRealTimeDataVo gasCompressorRealTimeDataVo = new GasCompressorRealTimeDataVo();
        gasCompressorRealTimeDataVo.setGascompressorName(MessageDesEnum.GASCOMPRESSOR.getKey());
        gasCompressorRealTimeDataVo.setTest("中文测试");
        gasCompressorRealTimeDataVo.setTest1("不包含测试");
        return gasCompressorRealTimeDataVo;
    }

    @MyMethodAnnotation
    public List<GasCompressorRealTimeDataVo> realtimedataList() {
        GasCompressorRealTimeDataVo gasCompressorRealTimeDataVo = new GasCompressorRealTimeDataVo();
        gasCompressorRealTimeDataVo.setGascompressorName(MessageDesEnum.GASCOMPRESSOR.getKey());
        gasCompressorRealTimeDataVo.setTest("中文测试");
        gasCompressorRealTimeDataVo.setTest1("不包含测试");
        GasCompressorRealTimeDataVo gasCompressorRealTimeDataVo1 = new GasCompressorRealTimeDataVo();
        gasCompressorRealTimeDataVo1.setGascompressorName(MessageDesEnum.HELLO.getKey());
        gasCompressorRealTimeDataVo1.setTest("中文测试");
        gasCompressorRealTimeDataVo1.setTest1("");
        return Arrays.asList(gasCompressorRealTimeDataVo, gasCompressorRealTimeDataVo1);
    }
}

package com.cet.eem.controller;

import com.cet.eem.entity.VO.GasCompressorRealTimeDataVo;
import com.cet.eem.enums.MessageEnum;
import com.cet.eem.service.I18nService;
import com.cet.eem.util.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestI18nController
 * @Description 国际化测试接口
 * @Author yucan
 **/
@RestController
@RequestMapping("/test")
public class TestI18nController {

    @Resource
    I18nService i18nService;

    @GetMapping("/i18n")
    public String testI18n() {
        String hello = MessageUtil.getMessage(MessageEnum.HELLO);
        String i18n = MessageUtil.getMessage(MessageEnum.I18N);
        String gascompressor = MessageUtil.getMessage(MessageEnum.GASCOMPRESSOR);

        Date date = new Date();
        String dateString = MessageUtil.formatDate(date);

        return hello + "\t" + i18n + "\t" + gascompressor + "\n" + dateString;
    }

    @GetMapping("/realtimedata")
    public String realtimedata() {
        GasCompressorRealTimeDataVo gasCompressorRealTimeDataVo = i18nService.realtimedata();
        return gasCompressorRealTimeDataVo.toString();
    }

    @GetMapping("/realtimedata2")
    public GasCompressorRealTimeDataVo realtimedata2() {
        GasCompressorRealTimeDataVo gasCompressorRealTimeDataVo = i18nService.realtimedata2();
        return gasCompressorRealTimeDataVo;
//        return Result.ok(gasCompressorRealTimeDataVo);
    }

    @GetMapping("/realtimedataList")
    public String realtimedataList() {
//        return Result.ok(i18nService.realtimedataList());
        return i18nService.realtimedataList().toString();
    }
}
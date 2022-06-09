package org.fyh.cloud.service.two.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.api.GoodsApi;
import org.fyh.cloud.service.two.api.dto.GetGoodsByUserDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fangyunhe
 * @version 1.0
 * @Description
 * @time 2021/1/26 15:10
 */
@Slf4j
@Service
public class GoodsApiServiceImlp implements GoodsApi {

    int time = 0;

    @Override
    public GetGoodsByUserDto getGoodsByUser(String id) throws Exception {
        time++;
        log.info("getGoodsByUser 接口请求测试{}", time);
        int sleep = 30000;
        log.warn("睡眠时间{}", sleep);
        Thread.sleep(sleep);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate = dtf2.format(LocalDateTime.now());
        return new GetGoodsByUserDto().setDesc("这是货品的描述").setName("iphone 12").setTime(strDate);
    }
}
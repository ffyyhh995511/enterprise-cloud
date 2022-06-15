package org.fyh.cloud.service.one;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

public class FeignClientConfig {

    @Bean
    public Retryer feignRetryer() {
        //fegin提供的默认实现，最大请求次数为5，初始间隔时间为100ms，下次间隔时间1.5倍递增，重试间最大间隔时间为1s，
        return new Retryer.Default();
    }


    @Bean
    public Request.Options options() {
        return new Request.Options(2000, TimeUnit.SECONDS, 2000, TimeUnit.SECONDS, true);
    }
}
package org.fyh.cloud.service.one.service.hystric;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.one.FeignClientConfig;
import org.fyh.cloud.service.two.api.GoodsApi;
import org.fyh.cloud.service.two.api.dto.GetGoodsByUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(url = "${service.two.feign.client.url}", name = "service-two", fallbackFactory = GoodsApiServiceHystric.GoodsApiFallbackFactory.class, configuration = {FeignClientConfig.class})
public interface GoodsApiServiceHystric extends GoodsApi {

    @Slf4j
    @Component
    class GoodsApiFallbackFactory implements FallbackFactory<GoodsApiServiceHystric> {

        @Override
        public GoodsApiServiceHystric create(Throwable throwable) {
            return new GoodsApiServiceHystric() {
                @Override
                public GetGoodsByUserDto getGoodsByUser(String id) throws Exception {
                    log.error("getGoodsByUser 熔断{}", throwable.getMessage(), throwable);
                    return new GetGoodsByUserDto().setName("接口熔断");
                }
            };
        }
    }
}

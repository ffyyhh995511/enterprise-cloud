package org.fyh.cloud.service.one.service.hystric;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.api.OrderApi;
import org.fyh.cloud.service.two.api.dto.GetOrderByUserDto;
import org.fyh.cloud.service.two.api.dto.OrderListDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author fangyunhe
 * @version 1.0
 * @Description
 * @time 2021/1/25 17:50
 */
@FeignClient(value = "SERVICE-TWO", fallbackFactory = OrderApiServiceHystric.OrderApiFallbackFactory.class)
public interface OrderApiServiceHystric extends OrderApi {

    @Slf4j
    @Component
    class OrderApiFallbackFactory implements FallbackFactory<OrderApiServiceHystric> {

        @Override
        public OrderApiServiceHystric create(Throwable throwable) {
            return new OrderApiServiceHystric() {

                @Override
                public GetOrderByUserDto getOrderByUser(String id) throws Exception {
                    log.error("getOrderByUser 熔断", throwable.getMessage(), throwable);
                    GetOrderByUserDto UserDto = new GetOrderByUserDto();
                    UserDto.setApplicationName("返回熔断数据");
                    return UserDto;
                }

                @Override
                public List<OrderListDto> getOrderList() {
                    log.error("getOrderList 熔断", throwable.getMessage(), throwable);
                    return Collections.emptyList();
                }
            };
        }
    }
}
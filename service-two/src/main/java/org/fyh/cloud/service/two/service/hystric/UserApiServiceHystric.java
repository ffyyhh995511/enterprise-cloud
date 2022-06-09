package org.fyh.cloud.service.two.service.hystric;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.one.api.UserApi;
import org.fyh.cloud.service.one.api.dto.ListUserByOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@FeignClient(value = "SERVICE-ONE", fallbackFactory = UserApiServiceHystric.UserApiFallbackFactory.class)
public interface UserApiServiceHystric extends UserApi {

    @Slf4j
    @Component
    class UserApiFallbackFactory implements FallbackFactory<UserApiServiceHystric> {
        @Override
        public UserApiServiceHystric create(Throwable throwable) {
            return new UserApiServiceHystric() {
                @Override
                public List<ListUserByOrderDto> listUserByOrder(Integer orderId) {
                    log.error("listUserByOrder 熔断", throwable.getMessage(), throwable);
                    return Collections.emptyList();
                }

                @Override
                public String getUserName(Integer id) {
                    log.error("getUserName 熔断", throwable.getMessage(), throwable);
                    return "熔断";
                }
            };
        }
    }
}

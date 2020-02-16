package org.fyh.cloud.service.one.service.hystric;

import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.one.dto.GetOrderByUserDto;
import org.fyh.cloud.service.one.service.remote.IOrderService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderServiceHystric implements IOrderService {

    /**
     * 熔断，返回自定义的数据对象
     * @param id
     * @return
     */
    @Override
    public GetOrderByUserDto getOrderByUser(String id) {
        GetOrderByUserDto UserDto = new GetOrderByUserDto();
        UserDto.setApplicationName("返回熔断数据");
        return UserDto;
    }
}

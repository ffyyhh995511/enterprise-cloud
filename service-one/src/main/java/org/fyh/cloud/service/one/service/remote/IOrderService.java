package org.fyh.cloud.service.one.service.remote;

import org.fyh.cloud.service.one.dto.GetOrderByUserDto;
import org.fyh.cloud.service.one.dto.OrderListDto;
import org.fyh.cloud.service.one.service.hystric.OrderServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "SERVICE-TWO", fallback = OrderServiceHystric.class)
public interface IOrderService {

    @GetMapping(value = "remote/order/getOrderByUser")
    GetOrderByUserDto getOrderByUser(@RequestParam(value = "id") String id);

    @GetMapping(value = "remote/order/getOrderList")
    List<OrderListDto> getOrderList();

}

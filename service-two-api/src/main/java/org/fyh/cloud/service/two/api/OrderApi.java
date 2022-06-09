package org.fyh.cloud.service.two.api;


import org.fyh.cloud.service.two.api.dto.GetOrderByUserDto;
import org.fyh.cloud.service.two.api.dto.OrderListDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * remote包目录下提供远程调用的http接口
 */
@RestController
@RequestMapping("order")
public interface OrderApi {

    /**
     * 提供远程调用的http接口
     *
     * @return
     */
    @GetMapping(value = "getOrderByUser")
    GetOrderByUserDto getOrderByUser(String id) throws Exception;


    /**
     * 提供远程调用的http接口
     *
     * @return
     */
    @GetMapping(value = "getOrderList")
    List<OrderListDto> getOrderList();
}

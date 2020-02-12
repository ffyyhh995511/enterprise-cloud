package org.fyh.cloud.service.two.controller;


import org.fyh.cloud.service.two.dto.ListUserByOrderDto;
import org.fyh.cloud.service.two.service.OrderService;
import org.fyh.cloud.service.two.service.remote.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    OrderService orderService;

    @Resource
    private IUserService iUserService;


    /**
     *
     * 提供给客户端（非微服务）的普通接口
     */
    @GetMapping(value = "test")
    public HashMap one(){
        return orderService.test();
    }

    /**
     * 发起远程调用
     * @param orderId
     * @return
     */
    @GetMapping(value = "listUserByOrder")
    public List<ListUserByOrderDto> listUserByOrder(Integer orderId){
        return iUserService.listUserByOrder(orderId);
    }


}

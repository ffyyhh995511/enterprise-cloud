package org.fyh.cloud.service.two.controller;


import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.dto.ListUserByOrderDto;
import org.fyh.cloud.service.two.service.OrderService;
import org.fyh.cloud.service.two.service.remote.IUserService;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("order")
@Slf4j
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
        StopWatch watch = new StopWatch("服务two调用服务one耗时时间");
        watch.start("开始");
        List<ListUserByOrderDto> list = iUserService.listUserByOrder(orderId);
        watch.stop();
        log.info(watch.prettyPrint());
        return list;
    }

    /**
     * 发起远程调用
     * @param id
     * @return
     */
    @GetMapping(value = "getUserName")
    public String getUserName(Integer id){
        StopWatch watch = new StopWatch("服务two调用服务one耗时时间");
        watch.start("开始");
        String userName = iUserService.getUserName(id);
        watch.stop();
        log.info(watch.prettyPrint());
        return userName;
    }

}

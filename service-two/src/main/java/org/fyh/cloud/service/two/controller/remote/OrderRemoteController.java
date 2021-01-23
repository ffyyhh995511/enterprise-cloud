package org.fyh.cloud.service.two.controller.remote;


import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.dto.OrderListDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * remote包目录下提供远程调用的http接口
 */
@Slf4j
@RestController
@RequestMapping("remote/order")
public class OrderRemoteController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    private int time = 0;

    /**
     * 提供远程调用的http接口
     * @return
     */
    @GetMapping(value = "getOrderByUser")
    public HashMap getOrderByUser(String id) throws Exception {
        time++;
        log.warn("测试值大小 time={}", time);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("port", port);
        map.put("time", time);
        map.put("applicationName", applicationName);
        map.put("date", System.currentTimeMillis());
        map.put("id", id);
        int sleep = 20000;
        log.warn("睡眠时间{}", sleep);
        Thread.sleep(sleep);
        return map;
    }


    /**
     * 提供远程调用的http接口
     * @return
     */
    @GetMapping(value = "getOrderList")
    public List<OrderListDto> getOrderList(){
        OrderListDto orderListDto1 = new OrderListDto();
        orderListDto1.setOrderId(new Long(1));
        orderListDto1.setOrderName("apple 11 pro");
        orderListDto1.setOrderStatus("缺货");

        OrderListDto orderListDto2 = new OrderListDto();
        orderListDto2.setOrderId(new Long(2));
        orderListDto2.setOrderName("macbook pro 2020");
        orderListDto2.setOrderStatus("缺货");
        List<OrderListDto> list = new ArrayList<>(2);

        list.add(orderListDto1);
        list.add(orderListDto2);

        return list;
    }
}

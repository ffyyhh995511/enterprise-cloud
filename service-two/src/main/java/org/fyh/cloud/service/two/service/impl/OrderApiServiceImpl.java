package org.fyh.cloud.service.two.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.api.OrderApi;
import org.fyh.cloud.service.two.api.dto.GetOrderByUserDto;
import org.fyh.cloud.service.two.api.dto.OrderListDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fangyunhe
 * @version 1.0
 * @Description
 * @time 2021/1/25 17:38
 */
@Slf4j
@Service
public class OrderApiServiceImpl implements OrderApi {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    private int time = 0;

    /**
     * 提供远程调用的http接口
     * @return
     */
    @Override
    public GetOrderByUserDto getOrderByUser(String id) throws Exception {
        time++;
        log.warn("测试值大小 time={}", time);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("port", port);
        map.put("time", time);
        map.put("applicationName", applicationName);
        map.put("date", System.currentTimeMillis());
        map.put("id", id);
        int sleep = 100;
        log.warn("睡眠时间{}", sleep);
        Thread.sleep(sleep);
        GetOrderByUserDto getOrderByUserDto = new GetOrderByUserDto();
        getOrderByUserDto.setApplicationName(applicationName)
                .setDate(String.valueOf(System.currentTimeMillis()))
                .setId(id).setPort(port);
        return getOrderByUserDto;
    }

    /**
     * 提供远程调用的http接口
     * @return
     */
    @Override
    public List<OrderListDto> getOrderList() {
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
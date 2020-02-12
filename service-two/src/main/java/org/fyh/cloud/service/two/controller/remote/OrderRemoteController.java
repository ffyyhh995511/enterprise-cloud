package org.fyh.cloud.service.two.controller.remote;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * remote包目录下提供远程调用的http接口
 */
@RestController
@RequestMapping("remote/order")
public class OrderRemoteController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 提供远程调用的http接口
     * @return
     */
    @GetMapping(value = "getOrderByUser")
    public HashMap getOrderByUser(String id){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("port", port);
        map.put("applicationName", applicationName);
        map.put("date", System.currentTimeMillis());
        map.put("id", id);
        return map;
    }
}

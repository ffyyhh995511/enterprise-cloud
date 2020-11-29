package org.fyh.cloud.service.two.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class OrderService {

    public HashMap test() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", 1);
        map.put("12", 12);
        map.put("13", 13);
        return map;
    }

    public Integer queryByOrderId() {
        return 1000;
    }
}

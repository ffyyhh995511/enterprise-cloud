package org.fyh.cloud.service.one.service;

import org.fyh.cloud.service.one.api.dto.ListUserByOrderDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    public HashMap<Object, Object> test(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", 1);
        map.put("12", 12);
        map.put("13", 13);
        return map;
    }

    /**
     * 这个方法提供远程调用，返还的对象只要结构一致就行
     * 可以Map --> object: key和objecgt的字段一一对应
     * 可以Object --> Object：不用的package和类名
     * @param orderId
     * @return
     */
    public List<ListUserByOrderDto> listUserByOrder(Integer orderId) {
        ListUserByOrderDto dto1 = new ListUserByOrderDto();
        dto1.setAge(100);
        dto1.setOrderId(orderId);
        dto1.setUsername("X");

        ListUserByOrderDto dto2 = new ListUserByOrderDto();
        dto2.setAge(200);
        dto2.setOrderId(orderId);
        dto2.setUsername("Y");

        ArrayList<ListUserByOrderDto> listUserByOrderDtos = new ArrayList<>();
        listUserByOrderDtos.add(dto1);
        listUserByOrderDtos.add(dto2);
        return listUserByOrderDtos;
    }

    public String getUserName(Integer id) {
        return "your name id is " + id;
    }
}


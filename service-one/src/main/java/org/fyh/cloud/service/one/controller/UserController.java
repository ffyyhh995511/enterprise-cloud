package org.fyh.cloud.service.one.controller;


import org.fyh.cloud.service.one.dto.GetOrderByUserDto;
import org.fyh.cloud.service.one.service.UserService;
import org.fyh.cloud.service.one.service.remote.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private IOrderService iOrderService;

    @Resource
    private UserService userService;

    /**
     *
     * @return
     */
    @GetMapping(value = "test")
    public HashMap test(){
        return userService.test();
    }

    /**
     * 发起远程调用
     * @param id
     * @return
     */
    @GetMapping(value = "getOrderByUser")
    public GetOrderByUserDto test1(String id){
        return iOrderService.getOrderByUser(id);
    }

}

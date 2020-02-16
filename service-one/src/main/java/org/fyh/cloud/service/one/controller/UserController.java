package org.fyh.cloud.service.one.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    public GetOrderByUserDto getOrderByUser(String id){
        return iOrderService.getOrderByUser(id);
    }

    /***
     * 静态的容错
     * @param id
     * @author fangyunhe
     * @date 14:28 14:28
     * @return java.util.HashMap
     */
    @HystrixCommand(fallbackMethod="getUserNameFallback")
    @GetMapping(value = "getUserName")
    public HashMap getUserName(Integer id){
        if (id > 10){
            throw new StackOverflowError();
        }
        HashMap map = new HashMap();
        map.put("username", "rooster");
        return map;
    }

    /***
     *
     * getUserName的fallback方法
     * @param id
     * @author fangyunhe
     * @date 14:29 14:29
     * @return java.util.HashMap
     */
    private HashMap getUserNameFallback(Integer id){
        HashMap map = new HashMap();
        map.put("username", "这是fallback");
        map.put("id", id);
        return map;
    }

}

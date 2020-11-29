package org.fyh.cloud.service.one.controller.remote;

import org.fyh.cloud.service.one.dto.GetOrderByUserDto;
import org.fyh.cloud.service.one.dto.ListUserByOrderDto;
import org.fyh.cloud.service.one.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * remote包目录下提供远程调用的http接口
 */
@RestController
@RequestMapping("remote/user")
public class UserRemoteController {

    @Resource
    UserService userService;

    /**
     * 提供远程调用
     * @param orderId
     * @return
     */
    @GetMapping(value = "listUserByOrder")
    public List<ListUserByOrderDto> listUserByOrder(Integer orderId){
        return userService.listUserByOrder(orderId);
    }

    /**
     * 提供远程调用
     * @param id
     * @return
     */
    @GetMapping(value = "getUserName")
    public String getUserName(Integer id){
        return userService.getUserName(id);
    }

}

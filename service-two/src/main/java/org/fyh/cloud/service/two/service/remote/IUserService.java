package org.fyh.cloud.service.two.service.remote;

import org.fyh.cloud.service.two.dto.ListUserByOrderDto;
import org.fyh.cloud.service.two.service.hystric.UserServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "SERVICE-ONE", fallback = UserServiceHystric.class)
public interface IUserService {

    @GetMapping(value = "remote/user/listUserByOrder")
    List<ListUserByOrderDto> listUserByOrder(@RequestParam(value = "orderId") Integer orderId);

    @GetMapping(value = "remote/user/getUserName")
    String getUserName(@RequestParam(value = "id") Integer id);

}

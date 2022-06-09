package org.fyh.cloud.service.one.api;

import org.fyh.cloud.service.one.api.dto.ListUserByOrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * remote包目录下提供远程调用的http接口
 */
@RestController
@RequestMapping("remote/user")
public interface UserApi {

    /**
     * 提供远程调用
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "listUserByOrder")
    List<ListUserByOrderDto> listUserByOrder(Integer orderId);

    /**
     * 提供远程调用
     *
     * @param id
     * @return
     */
    @GetMapping(value = "getUserName")
    String getUserName(Integer id);

}

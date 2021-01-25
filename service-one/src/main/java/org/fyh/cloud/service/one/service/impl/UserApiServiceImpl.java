package org.fyh.cloud.service.one.service.impl;

import org.fyh.cloud.service.one.api.UserApi;
import org.fyh.cloud.service.one.api.dto.ListUserByOrderDto;
import org.fyh.cloud.service.one.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fangyunhe
 * @version 1.0
 * @Description
 * @time 2021/1/25 17:09
 */
@Service
public class UserApiServiceImpl implements UserApi {

    @Resource
    UserService userService;

    /**
     * 提供远程调用
     * @param orderId
     * @return
     */
    @Override
    public List<ListUserByOrderDto> listUserByOrder(Integer orderId) {
        return userService.listUserByOrder(orderId);
    }

    /**
     * 提供远程调用
     * @param id
     * @return
     */
    @Override
    public String getUserName(Integer id) {
        return userService.getUserName(id);
    }
}
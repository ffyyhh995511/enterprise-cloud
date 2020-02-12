package org.fyh.cloud.service.two.service.hystric;

import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.dto.ListUserByOrderDto;
import org.fyh.cloud.service.two.service.remote.IUserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserServiceHystric implements IUserService {

    @Override
    public List<ListUserByOrderDto> listUserByOrder(Integer orderId) {
        ListUserByOrderDto listUserByOrderDto = new ListUserByOrderDto();
        listUserByOrderDto.setAge(0);
        listUserByOrderDto.setUsername("熔断");
        listUserByOrderDto.setOrderId(0);
        List<ListUserByOrderDto> list = new ArrayList<>();
        list.add(listUserByOrderDto);
        return list;
    }
}

package org.fyh.cloud.service.two.api;

import org.fyh.cloud.service.two.api.dto.GetGoodsByUserDto;
import org.fyh.cloud.service.two.api.dto.GetOrderByUserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public interface GoodsApi {

    @PostMapping(value = "getGoodsByUser")
    GetGoodsByUserDto getGoodsByUser(String id) throws Exception;
}

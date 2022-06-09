package org.fyh.cloud.service.two.controller;


import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.hystrix.QueryOrderIdCommand;
import org.fyh.cloud.service.two.service.OrderService;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("mamyOrder")
public class ManyOrderController {

    @Resource
    OrderService orderService;

    /**
     * 自定义熔断
     *
     * @return
     */
    @GetMapping(value = "queryByOrderId")
    public Integer queryByOrderId() {
        StopWatch watch = new StopWatch("自定义熔断");
        watch.start("开始");
        QueryOrderIdCommand queryOrderIdCommand = new QueryOrderIdCommand(orderService);
        Integer execute = queryOrderIdCommand.execute();
        watch.stop();
        log.info(watch.prettyPrint());
        return execute;
    }

}

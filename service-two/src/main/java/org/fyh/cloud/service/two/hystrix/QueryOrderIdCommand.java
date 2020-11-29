package org.fyh.cloud.service.two.hystrix;

import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;
import org.fyh.cloud.service.two.service.OrderService;

/**
 *
 *
 * @author fangyunhe
 * @version 1.0
 * @date 2020/11/29 22:51
 */
@Slf4j
public class QueryOrderIdCommand extends HystrixCommand<Integer> {
    private OrderService orderService;

    public QueryOrderIdCommand(OrderService orderService) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("orderService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("queryByOrderId"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)//至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
                        .Setter().withCoreSize(10)));
        this.orderService = orderService;
    }

    @Override
    protected Integer run() {
        return orderService.queryByOrderId();
    }

    @Override
    protected Integer getFallback() {
        return -1;
    }
}

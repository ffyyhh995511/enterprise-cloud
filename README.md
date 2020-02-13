# enterprise-cloud
整合企业级微服务必要的组件和代码结构规范

## 项目介绍
1. 服务的注册与发现(Eureka)
2. 动态路由网关(zuul)
3. 负载均衡、远程调用、熔断器(ribbon、feign、hystrix)
4. 服务链路追踪(Sleuth、Zipkin)
5. 断路器监控

## 代码分层说明
~~~
├─common
├─controller
│  └─remote
├─dao
├─dto
├─entity
├─service
│  ├─hystric
│  └─remote
│  └─impl
├─util
│─vo
└─config
~~~
common 存放公共的类，比如公共常量类，枚举类    
dao 存放数据库操作类，比如mybatis框架的maper类  
dto 全称是Data Transfer Object, 用于**微服务**传输对象   
vo 全称是value object,业务代码开发中用到，区别于dto的是，dto只能用于微服务层
entity 存放表映射到类的目录，可以理解就是持久化对象  
controller 存放http接口  
controller.remote 存放**微服务**对外提供的接口方法
config 存放spirng框架的配置对象，比如druidConfig,redidConfig类  
service 存放普通的业务逻辑类，比如userService类，如果需要用到interface接口文件，也是存放这个路径下  
service.impl 存放service目录interface的实现类，文件命名以Impl作为后缀   
service.remote 存放微服务调用的interface,里面的接口以I作为前缀，如下模板   
~~~
@FeignClient(value = "SERVICE-TWO", fallback = OrderServiceHystric.class)
public interface IOrderService {

    @GetMapping(value = "remote/order/getOrderByUser")
    GetOrderByUserDto getOrderByUser(@RequestParam(value = "id") String id);

}
~~~
service.hystric 存放微服务熔断类，类文件以Hystric作为后缀，如下模板   
~~~
@Component
public class OrderServiceHystric implements IOrderService {

    /**
     * 熔断，返回自定义的数据对象
     * @param id
     * @return
     */
    @Override
    public GetOrderByUserDto getOrderByUser(String id) {
        GetOrderByUserDto UserDto = new GetOrderByUserDto();
        UserDto.setApplicationName("null");
        return UserDto;
    }
}
~~~

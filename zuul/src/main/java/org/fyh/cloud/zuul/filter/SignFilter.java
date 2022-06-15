package org.fyh.cloud.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fangyunhe
 * @version 1.0
 * @Description
 * @time 2022/6/13 15:16
 */

@Slf4j
@Component
//@Profile({"dev"})
public class SignFilter extends ZuulFilter {

    /**
     * 返回四种类型：
     * pre pre-routing过滤，路由前过滤
     * routing 在路由请求时被调用
     * post routing和error过滤器之后被调用
     * error 处理请求发生错误的时候调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("zuul网关进行pre过滤");

        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulResponseHeader("Content-Type", "application/json;charset=UTF-8");
        HttpServletRequest request = ctx.getRequest();
        if (StringUtils.isBlank(request.getParameter("b"))) {
            // 未经过逻辑
            // 用来给后面的 Filter 标识，是否继续执行，通过ctx.get()获取值
            ctx.set("abc", false);
            // 返回信息
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", 400);
            jsonObject.put("msg", "签名有误");
            jsonObject.put("data", null);
            ctx.setResponseBody(jsonObject.toString());
            // 对该请求禁止路由，禁止访问下游服务
            ctx.setSendZuulResponse(false);
            return null;
        }

        // 用来给后面的 Filter 标识，是否继续执行
        ctx.set("abc", true);
        return null;
    }
}
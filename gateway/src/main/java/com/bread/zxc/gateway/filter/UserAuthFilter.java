package com.bread.zxc.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Created by Administrator on 2017/8/5.
 * filterType：该函数需要返回一个字符串来代表过滤器的类型，而这个类型就是在HTTP请求过程中定义的各个阶段。在Zuul中默认定义了四种不同生命周期的过滤器类型，具体如下：
    pre：可以在请求被路由之前调用。
    routing：在路由请求时候被调用。
    post：在routing和error过滤器之后被调用。
    error：处理请求时发生错误时被调用。
    filterOrder：通过int值来定义过滤器的执行顺序，数值越小优先级越高。
    shouldFilter：返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
    run：过滤器的具体逻辑。在该函数中，我们可以实现自定义的过滤逻辑，来确定是否要拦截当前的请求，不对其进行后续的路由，或是在请求路由返回结果之后，对处理结果做一些加工等。.

 */
public class UserAuthFilter extends ZuulFilter {

    private Log logger = LogFactory.getLog(UserAuthFilter.class);

    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 1;
    }

    public boolean shouldFilter() {
        String path = RequestContext.getCurrentContext().getRequest().getRequestURI();
        return path.startsWith("/auth/oauth/token");
    }

    public Object run() {
        logger.debug("executing userauth filter add client/client secret to Http Header 'Authorization'");
        String clientCredentials = "client:secret";

        Base64 base64 = new Base64();
        String encodedCredentials = base64.encodeToString(clientCredentials.getBytes());

        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("Authorization", "Basic " + encodedCredentials);
        return null;
    }
}

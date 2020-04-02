package com.bread.enlighten.zxc.restful.blog.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * Created by kevin on 16-10-14.
 */
public class ZuulExceptionFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ZuulExceptionFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Object e = ctx.get("error.exception");
        if (e != null && e instanceof ZuulException) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            Object e = ctx.get("error.exception");

            if (e != null && e instanceof ZuulException) {
                ZuulException zuulException = (ZuulException) e;
                ctx.remove("error.status_code");
                ctx.setResponseBody("{ \"resultCode\": 50003, \"resultMsg\": \"THE SERVER IS DOWN\", \"data\": null }");
                ctx.getResponse().setContentType("application/json");
                ctx.setResponseStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

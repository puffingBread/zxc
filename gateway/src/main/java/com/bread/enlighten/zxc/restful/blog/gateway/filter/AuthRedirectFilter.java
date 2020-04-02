package com.bread.enlighten.zxc.restful.blog.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by kevin on 16-10-14.
 */
public class AuthRedirectFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(AuthRedirectFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println(httpRequest.getRequestURI());
        String path = httpRequest.getRequestURI();

        String newPath = path.replace("/userauth", "/user");
        httpRequest.getRequestDispatcher(newPath).forward(request, response);

        chain.doFilter(request, response);
        return;
    }

    @Override
    public void destroy() {

    }
}

package com.example.demo.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: kaptcha
 * @description: 过滤器
 * @author: wangdong
 * @create: 2020-11-19 16:23
 **/
@Component
public class FilterConfig implements Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)res;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        //response.setHeader("Access-Control-Allow-Origin","127.0.0.1:63342");
        //response.setHeader("Access-Control-Allow-Origin","*");//允许所有域名跨域访问该资源，根据项目实际需要可以设置允许特定的域名访问
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");//允许的跨域请求方式
		/*每次异步请求都发起预检请求，也就是说，发送两次请求。第一次是浏览器使用OPTIONS方法发起一个预检请求，第二次才是真正的异步请求，第一次的预检请求获知服务器是否
		允许该跨域请求：如果允许，才发起第二次真实的请求；如果不允许，则拦截第二次请求。*/
        response.setHeader("Access-Control-Max-Age", "0");//每次异步请求都发起预检请求，也就是说，发送两次请求。
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With,"
                + " If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires,"
                + " Content-Type, X-E4M-With,userId,token");//跨域请求允许包含的头
        response.setHeader("Access-Control-Allow-Credentials", "true");	//是否支持跨域，是否允许请求带有验证信息
        response.setHeader("XDomainRequestAllowed", "1");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}

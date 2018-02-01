package com.xmsmartcity.util;
 
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * CORSFilter 解决跨域问题
 * @author mengyao
 *
 */
@Component
public class InitCORSFilter implements Filter{

    private Logger logger = LoggerFactory.getLogger(InitCORSFilter.class);
     
    public InitCORSFilter() {
        logger.info("==== 初始化系统允许跨域请求 ====");
    }
     
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	/**
	 * 解决跨域：Access-Control-Allow-Origin，值为*表示服务器端允许任意Domain访问请求
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter(request, servletResponse);
	}

	@Override
	public void destroy() {}
     
}
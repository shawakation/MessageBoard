package com.yckj.messageboard.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * Copyright(c) YCHS. 2018 ALL Rigthts Reserved
 * 
 * 乱码处理过滤器，支持处理get和post请求乱码问题
 * Date:2018年8月9日
 * @author zhoujy
 * @version 1.0
 */
public class EncodingFilter implements Filter {
	/**
	 * 默认编码类型
	 */
	private String charset = "UTF-8";

	/**
	 * 过滤器销毁方法，什么都不做
	 */
	@Override
	public void destroy() {
		
	}

	/**
	 * 每个请求过滤都进行编码处理，编码处理完成之后进行放行
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//将request对象转换为HttpServletRequest接口对象
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		
		 //设置响应编码
        response.setCharacterEncoding(this.charset);
        response.setContentType("text/html;charset=" + this.charset);
        
        /*
         * 创建一个带有转码功能、且实现HttpServletRequest接口
         * 的request对象，使用该对象来替换原来的request对象，
         * 将其传递到目标Servlet中去，当Servlet中调用getParameter
         * 方法时，就会进行编码转换
         */
        EncodingRequest encodingRequest = new EncodingRequest(httpServletRequest, this.charset);
        chain.doFilter(encodingRequest, response);
	}

	/**
	 * 过滤器初始化调用方法
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.charset = filterConfig.getInitParameter("charset");
	}

}

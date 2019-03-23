package com.yckj.messageboard.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Copyright(c) YCHS. 2018 ALL Rigthts Reserved
 * 
 * HttpServletRequest类型对象所对应的装饰者类，实现了装饰者模式
 * 通过该类来扩展HTTPServletRequest方法，处理get 和POST方法的乱码问题
 * Date:2018年8月9日
 * @author zhoujy
 * @version 1.0
 */
public class EncodingRequest extends HttpServletRequestWrapper {
	/**
	 * 默认的编码处理类型，为UTF-8
	 */
	private String charset = "UTF-8";
	
	/**
	 * 自定义装饰者类的构造函数
	 * @param request 实际传入的HttpServletRequest对象
	 * @param charset 实际进行编码处理的编码值
	 */
	public EncodingRequest(HttpServletRequest request,String charset) {
		super(request);
		this.charset = charset;
	}
	
	/**
	 * 重写HttpServletRequest接口对象的父类中的getParameter方法，
	 * 提供编码处理功能。
	 */
	@Override
	public String getParameter(String name) {
		//获取当前请求的request对象
		HttpServletRequest request = (HttpServletRequest)getRequest();
		
		//获取请求类型数据
		String method = request.getMethod();
		
		//Post请求乱码处理
		if("post".equalsIgnoreCase(method)) {
			try {
				request.setCharacterEncoding(charset);
				return request.getParameter(name);
			} catch (UnsupportedEncodingException e) {
				System.out.println("Post请求编码处理出现异常！");
				e.printStackTrace();
			}
		}else if("get".equalsIgnoreCase(method)){
			//get请求乱码处理
			String value = request.getParameter(name);
			
			try {
				value = new String(value.getBytes("ISO-8859-1"),charset);
			} catch (UnsupportedEncodingException e) {
				System.out.println("Get请求编码处理出现异常！");
				e.printStackTrace();
			}
			return value;
		}
		
		return request.getParameter(name);
	}
}

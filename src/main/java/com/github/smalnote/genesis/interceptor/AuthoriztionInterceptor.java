package com.github.smalnote.genesis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthoriztionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader("Authorization-Token");
		String data = request.getHeader("Authorization-Data");
		if (token == null || data == null) {
			response.setStatus(401);
			return false;
		}
		
		String username = "username";
		String operation = "operation";
		ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		attrs.setAttribute("user", username, 0);
		attrs.setAttribute("operation", operation, 0);
		
		return true;
	}
}

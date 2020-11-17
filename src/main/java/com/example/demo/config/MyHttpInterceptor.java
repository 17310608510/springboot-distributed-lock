package com.example.demo.config;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * @author 作者 zuoruibo:
 * @date 创建时间：2020年11月12日 上午11:50:51
 * @version 1.0
 * @parameter
 * @since 拦截处理类
 * @return
 */
@Component
public class MyHttpInterceptor extends HandlerInterceptorAdapter {
	protected static Logger logger = LoggerFactory.getLogger(MyHttpInterceptor.class);

	

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String queryString = "";
		// 去掉最后一个空格
		Map<String, String[]> params = request.getParameterMap();
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				queryString += key + "=" + value + "&";
			}
		}
		queryString = queryString.equals("") ? null : queryString.substring(0, queryString.length() - 1);
		logger.info(String.format("请求参数, url: %s, method: %s, params: %s", url, method, queryString));
		
		return true;
	}
}

package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;

/**
 * @author 作者 zuoruibo:
 * @date 创建时间：2020年11月12日 上午11:28:50
 * @version 1.0
 * @parameter
 * @since 拦截器定义
 * @return
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	// 让bean提前加载，让拦截器中的@Autowired生效
	@Bean
	public HandlerInterceptor getMyInterceptor() {
		return new MyHttpInterceptor();
	}

	/**
	 * 可定义多个拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 定义过滤拦截的url名称，拦截所有请求
		registry.addInterceptor(this.getMyInterceptor()).addPathPatterns("/**");
//		registry.addInterceptor(其他拦截器).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}

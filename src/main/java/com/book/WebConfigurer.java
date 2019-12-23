package com.book;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 默认首页
 * @author Lenovo
 *
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer{
	

	private final static String URI_VIEWCONTROLLER_PREFIX = "/**/*";
    private final static String URI_VIEWCONTROLLER_SUFFIX = ".do";
    private final static String URI_VIEWCONTROLLER_REDIRECT = "login";

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		WebMvcConfigurer.super.addViewControllers(registry);
		//registry.addViewController("/").setViewName("forward:/hello2");
		//registry.addViewController("/").setViewName("index2");
		//将 /**/*.do重定向到 /**/login
        //registry.addRedirectViewController(URI_VIEWCONTROLLER_PREFIX + URI_VIEWCONTROLLER_SUFFIX, URI_VIEWCONTROLLER_REDIRECT);
		registry.addViewController("/").setViewName("login");
		//最高权限
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
 
	//静态资源访问 添加静态资源文件，外部可以直接访问地址
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/jsp/**").addResourceLocations("/WEB-INF/"+"/jsp/");
		//registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}
}

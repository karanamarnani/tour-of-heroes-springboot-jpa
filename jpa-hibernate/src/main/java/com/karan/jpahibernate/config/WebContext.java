package com.karan.jpahibernate.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebContext implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("HEAD", "GET", "PUT",
//		"POST", "DELETE", "PATCH");
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("search");
//		registry.addViewController("/monitor").setViewName("monitor");
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new PageableHandlerMethodArgumentResolver());
	}
}

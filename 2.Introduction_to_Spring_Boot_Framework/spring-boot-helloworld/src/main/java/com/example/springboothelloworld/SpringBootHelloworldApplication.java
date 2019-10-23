package com.example.springboothelloworld;

import com.example.springboothelloworld.servlet.HelloFilter;
import com.example.springboothelloworld.servlet.HelloListener;
import com.example.springboothelloworld.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.annotation.WebServlet;

@SpringBootApplication

public class SpringBootHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloworldApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean servletBean = new ServletRegistrationBean(new HelloServlet());
		servletBean.addUrlMappings("/helloServlet");
		return servletBean;
	}

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean(new HelloFilter());
		filterBean.addUrlPatterns("/helloServlet");
		return filterBean;
	}
	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletListnerRegistrationBean(){
		ServletListenerRegistrationBean listnerBean = new ServletListenerRegistrationBean(new HelloListener());

		return listnerBean;
		}
	}




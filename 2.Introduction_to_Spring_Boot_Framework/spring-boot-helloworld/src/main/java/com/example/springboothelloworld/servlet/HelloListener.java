package com.example.springboothelloworld.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HelloListener implements ServletContextListener{

    @Override
    public void contextDestroyed (ServletContextEvent servletContextEvent){
        System.out.println("servlet context destroyed");
    }

    public void contextInitialized(ServletContextEvent  servletContextEvent){
        System.out.println("Servlet Context Initialized");
    }

}

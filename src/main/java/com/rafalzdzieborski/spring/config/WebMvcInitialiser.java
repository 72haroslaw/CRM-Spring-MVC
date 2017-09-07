package com.rafalzdzieborski.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebMvcInitialiser implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MVCConfigurer.class);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
		registration.addMapping("/");
		registration.setLoadOnStartup(1);
	}
}
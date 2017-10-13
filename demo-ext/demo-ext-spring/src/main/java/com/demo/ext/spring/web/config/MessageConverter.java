package com.demo.ext.spring.web.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MessageConverter {

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		ObjectMapper om = new ObjectMapper();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = converter.getObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
		return converter;
	}
	
	@Bean
	public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping(){
		DefaultAnnotationHandlerMapping mapping = new DefaultAnnotationHandlerMapping();
		return mapping;
	}
	
	@Bean
	public AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter(){
		AnnotationMethodHandlerAdapter adapter = new AnnotationMethodHandlerAdapter();
		return adapter;
	}
}

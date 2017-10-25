package com.demo.user.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import com.demo.common.util.LocalServers;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="com.demo")
public class App implements EmbeddedServletContainerCustomizer{
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		Integer port = LocalServers.getAvailablePort(9000);
		System.setProperty("server.port", port.toString());
		container.setPort(port);
	}
	
}

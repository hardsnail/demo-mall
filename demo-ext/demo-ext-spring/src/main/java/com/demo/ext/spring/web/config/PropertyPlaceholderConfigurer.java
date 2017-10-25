package com.demo.ext.spring.web.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import com.demo.ext.spring.context.PropertyHolder;

@Component
public class PropertyPlaceholderConfigurer
		extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {

	public PropertyPlaceholderConfigurer() {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			String springProfilesActive = PropertyHolder.get("spring.profiles.active");
			Resource[] resources = resolver.getResources("classpath*:env/" + springProfilesActive + "/*.properties");
			setLocations(resources);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		PropertyHolder.putAll(props);
	}

	@Override
	protected String resolvePlaceholder(String placeholder, Properties props, int systemPropertiesMode) {
		return super.resolvePlaceholder(placeholder, props, systemPropertiesMode);
	}
	
}

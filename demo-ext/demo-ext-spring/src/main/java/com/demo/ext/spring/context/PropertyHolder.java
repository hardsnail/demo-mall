package com.demo.ext.spring.context;

import java.util.Properties;

public class PropertyHolder {

	private static Properties properties = new Properties();

	public static String get(String key) {
		String value = System.getenv(key);
		if (value == null) {
			value = System.getProperty(key);
		}
		if (value == null) {
			value = properties.getProperty(key);
		}
		return value;
	}

	public static String get(String key, String defaultValue) {
		String value = get(key);
		return value == null ? defaultValue : value;
	}
	
	public static Integer getInteger(String key) {
		String stringValue = get(key);
		return stringValue == null ? null : Integer.valueOf(stringValue);
	}
	
	public static void put(Object key, Object value){
		properties.put(key, value);
	}
	
	public static void putAll(Properties properties){
		System.out.println("putAll");
		PropertyHolder.properties.putAll(properties);
	}

}

package com.demo.user.server.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.ext.spring.context.PropertyHolder;
import com.mysql.jdbc.Driver;

@Configuration
public class DataSourceConfig {

	@Bean("dataSource")
	@Profile({ "dev", "test" })
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		Driver driver;
		try {
			driver = (Driver) Class.forName(PropertyHolder.get(PropertyKey.JDBC_DRIVER)).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		dataSource.setUrl(PropertyHolder.get(PropertyKey.JDBC_URL));
		dataSource.setDriver(driver);
		dataSource.setUsername(PropertyHolder.get(PropertyKey.JDBC_USERNAME));
		dataSource.setPassword(PropertyHolder.get(PropertyKey.JDBC_PASSWORD));
		dataSource.setMaxActive(PropertyHolder.getInteger(PropertyKey.DATASOURCE_MAXACTIVE));
		return dataSource;
	}

	@Bean("dataSource")
	@Profile({ "prod" })
	public DataSource prodDataSource() {
		JndiDataSourceLookup lookup = new JndiDataSourceLookup();
		return lookup.getDataSource(PropertyHolder.get("jdbc.dataSourceName"));
	}

}

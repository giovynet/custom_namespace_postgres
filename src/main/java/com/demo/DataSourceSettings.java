package com.demo;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceSettings {
	@Bean(name = "ds-postgres")
	@ConfigurationProperties(prefix = "ds.postgres.datasource")
	public DataSource dataSourceOne() {
		DataSource datasource = DataSourceBuilder.create().build();
		return datasource;
	}
	
	
}

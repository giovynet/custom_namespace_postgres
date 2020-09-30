package com.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.demo.dao.CitiesDao;

@SpringBootTest
class DataSourceApplicationTests {
	
	@Autowired
	@Qualifier("ds-postgres")
	DataSource dsPostgres;

	@Autowired
	CitiesDao citiesDao;
	
	@Test
	void dsConnectionTest() throws SQLException {
		Connection connection = dsPostgres.getConnection();
		Assert.notNull(connection, "Connection is NULL...");		
	}
	
	
	@Test
	void testDataAccess() {
		try {			
			List<String> list = citiesDao.selectCities();
			list.forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

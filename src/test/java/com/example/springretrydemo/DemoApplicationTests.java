package com.example.springretrydemo;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplicationTests.class);
	@Autowired
	private BillingClientService client;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void billingService(){
		try{
			String msg	=	client.callRetryService();
			LOGGER.info(msg);
		}catch(SQLException ex){
			LOGGER.error("sql exception"+ ex.getMessage());
			ex.printStackTrace();
		}
	}

}

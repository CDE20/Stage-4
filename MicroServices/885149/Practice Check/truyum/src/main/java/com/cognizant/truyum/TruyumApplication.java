package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemDaoSerivce;


@SpringBootApplication(scanBasePackages="com.*")
@EnableDiscoveryClient
public class TruyumApplication 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	private static MenuItemDaoSerivce menuimpl;
    public static void main( String[] args )
    {
    	LOGGER.info("Inside Main");
    	SpringApplication.run(TruyumApplication.class,args);
    	
    	//test();
    }
    
    private static void test() {
    	LOGGER.info("Start");
    	List<MenuItem> menu = menuimpl.getAllMenuItems();
    	LOGGER.debug("MenuItem={}",menu);
    	LOGGER.info("Stop");
    }
}

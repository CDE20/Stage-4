package com.cognizant.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
@ComponentScan("com")
public class TruyumApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start");

		ApplicationContext applicationContext = SpringApplication.run(TruyumApplication.class, args);
		
//		MenuItemService menuItemService = applicationContext.getBean(MenuItemService.class);
//		menuItemService.getMenuItemListAdmin().stream().forEach(System.out::println);
//		
//		System.out.println();
//		
//		menuItemService.getMenuItemListCustomer().stream().forEach(System.out::println);

		LOGGER.info("End");
	}

}

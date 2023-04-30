package com.simpana.eventBookingSystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventBookingSystemApplication extends SpringBootServletInitializer {
	
	private static Class<EventBookingSystemApplication> applicationClass = EventBookingSystemApplication.class;
	public static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		logger.info("Starting EBS application..");
		SpringApplication.run(EventBookingSystemApplication.class, args);
	}
	
			
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		     return application.sources(applicationClass);
		}



}

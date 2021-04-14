package com.accolite.assignment.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EmployeeApplication  { //Main class

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	

}

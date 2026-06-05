package com.todoappjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.FilterType;

import com.unwanted.Unwanted;

@SpringBootApplication
@ComponentScan(basePackages= "com")
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes= {Unwanted.class}))
public class TodoAppJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppJwtApplication.class, args);
	}

}

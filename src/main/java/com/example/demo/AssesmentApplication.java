package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssesmentApplication {
	
    public static String VERSION;

    static {
        System.setProperty("spring.jpa.hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
    }
	
	public static void main(String[] args) {
		SpringApplication.run(AssesmentApplication.class, args);
	}

}

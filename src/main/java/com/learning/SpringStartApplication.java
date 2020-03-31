package com.learning;

import com.learning.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@Slf4j
@EnableCaching
public class SpringStartApplication implements CommandLineRunner {

	@Autowired
	private IAccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(SpringStartApplication.class, args);
	}

	@Override
	public void run(String... args){
		for(int i=1; i<=3; i++){
			log.info("---->" + accountService.findAccountById(i));
		}
		for(int i=1; i<=3; i++){
			log.info("---->" + accountService.findAccountById(i));
		}
	}
}

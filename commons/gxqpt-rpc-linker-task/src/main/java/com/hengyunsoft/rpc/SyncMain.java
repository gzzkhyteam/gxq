package com.hengyunsoft.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class SyncMain {

	public static void main(String[] args) {

		SpringApplication.run(SyncMain.class, args);
	}
}

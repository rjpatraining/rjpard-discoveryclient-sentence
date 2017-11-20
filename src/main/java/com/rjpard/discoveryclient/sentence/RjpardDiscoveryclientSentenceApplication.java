package com.rjpard.discoveryclient.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RjpardDiscoveryclientSentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RjpardDiscoveryclientSentenceApplication.class, args);
	}
}

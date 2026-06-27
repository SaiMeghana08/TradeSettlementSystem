package com.Settlement.TradeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class TradeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeServiceApplication.class, args);
	}

}

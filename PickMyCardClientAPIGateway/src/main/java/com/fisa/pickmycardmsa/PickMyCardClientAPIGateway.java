package com.fisa.pickmycardmsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PickMyCardClientAPIGateway {

    public static void main(String[] args) {
        SpringApplication.run(PickMyCardClientAPIGateway.class, args);
    }

}

package org.example.springboot.pollsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PollsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PollsServiceApplication.class, args);
    }

}

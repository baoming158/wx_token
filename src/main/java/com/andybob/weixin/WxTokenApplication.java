package com.andybob.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(value = {"com.andybob.weixin"})
public class WxTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxTokenApplication.class, args);
	}
}

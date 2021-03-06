package com.example.spring.cloud.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.cloud.service1.fien.Service2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
@RequestMapping("/service1")
public class SpringCloudService1Application {
	
	@Autowired
	private Service2 service2;

	@Value("${server.port}")
	private String port;
	
	
	@Value("${my.username}")
	private String userName;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudService1Application.class, args);
	}
	
	@GetMapping("/serviceDetail")
	public String getFirstService() {
		return service2.invokeService2()+" from service1 having port : "+port+" username :"+getUserName();
	}
	

	@RefreshScope
	public String getUserName() {
		return userName;
	}
}

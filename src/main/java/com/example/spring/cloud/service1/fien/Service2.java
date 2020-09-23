package com.example.spring.cloud.service1.fien;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:9095/", name="service2")
public interface Service2 {

	@GetMapping("/service2Detail")
	public String invokeService2();
}

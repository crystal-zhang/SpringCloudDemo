package org.crystal.FeignClient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-provider2")
public interface OrderService {
	@RequestMapping("/addEmployees")
	String addEmployees();
}

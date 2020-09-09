package org.crystal.FeignClient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-provider1")
public interface UserService {
	@RequestMapping("/addUserBalance")
	String addUserBalance();
}

package org.crystal.FeignClient.rest;

import org.crystal.FeignClient.service.OrderService;
import org.crystal.FeignClient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FeignController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	@RequestMapping("hello")
	public String getConfigString() {
		userService.addUserBalance();
		orderService.addEmployees();

		return "OK";
	}
}

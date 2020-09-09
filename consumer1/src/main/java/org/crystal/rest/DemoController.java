package org.crystal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/index")
	public String test() {
		String resultString = restTemplate.getForEntity("http://eureka-provider/getConfig", String.class).getBody();
		return resultString;
	}
}

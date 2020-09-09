package org.crystal.Client.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*@ControllerAdvice
@ResponseBody*/
public class ExceptionHandler {

	private Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

	@org.springframework.web.bind.annotation.ExceptionHandler
	public String handleException(Exception e) {
		log.info("捕获异常信息");
		return "error";

	}

}

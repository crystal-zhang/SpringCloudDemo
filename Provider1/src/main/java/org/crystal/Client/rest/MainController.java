package org.crystal.Client.rest;

import org.crystal.Client.dao.UserBalanceRepository;
import org.crystal.Client.entity.UserBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
public class MainController {
	@Autowired
	private UserBalanceRepository userBalanceRepository;

	@RequestMapping("/getTime")
	public String getTime() {
		return LocalDateTime.now().toString();
	}

	@RequestMapping("/getUserBalance")
	public UserBalance getUser(Integer id) {
		Optional<UserBalance> userBalance = userBalanceRepository.findById(new Integer(1));
		return userBalance.get();
	}

	@RequestMapping("/addUserBalance")
	@Transactional
	public UserBalance addUser() {
		String name = UUID.randomUUID().toString().substring(6, 10);
		UserBalance userBalance = new UserBalance();
		userBalance.setName(name);
		userBalance.setBalance(new BigDecimal(200));
		UserBalance dbBalance = userBalanceRepository.save(userBalance);
		return dbBalance;
	}

}

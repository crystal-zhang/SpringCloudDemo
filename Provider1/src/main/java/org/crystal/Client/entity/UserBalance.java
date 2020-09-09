package org.crystal.Client.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBalance {
	private static final long serialVersionUID = 1L;
	@Id
	private int id;

	private String name;

	/**
	 * 余额
	 */
	private BigDecimal balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}

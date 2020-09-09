package org.crystal.Client.rest;

import org.crystal.Client.dao.EmployeesRepository;
import org.crystal.Client.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
//@RefreshScope // 开启刷新功能
public class DemoController {
	@Value("${spring.application.name}")
	private String from;
	@Autowired
	private DiscoveryClient discoverClient;
	@Autowired
	private EmployeesRepository employeesRepository;

	@RequestMapping("/index")
	public List<Employees> test() {
		List<Employees> employees = employeesRepository.findByEmpNo(10007);

		return employees;
	}

	@RequestMapping("/addEmployees")
	@Transactional
	public Employees addEmployees() {
		Employees employees = new Employees();
		employees.setEmpNo(10013);
		employees.setFirstName("zhang");
		employees.setGender("F");
		employees.setHireDate(LocalDate.now());
		employees.setBirthDate(LocalDate.now());
		employeesRepository.save(employees);
		return employees;
	}

	@RequestMapping("/from")
	public String testConfig() {
		return from;
	}

	@RequestMapping("/getConfig")
	public Object getConfig() {
		return this.discoverClient;
	}
}

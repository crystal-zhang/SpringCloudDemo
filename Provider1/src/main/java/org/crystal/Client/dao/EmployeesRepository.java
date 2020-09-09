package org.crystal.Client.dao;

import org.crystal.Client.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

	List<Employees> findByEmpNo(Integer empNo);

	List<Employees> findByFirstName(String firstName);
}

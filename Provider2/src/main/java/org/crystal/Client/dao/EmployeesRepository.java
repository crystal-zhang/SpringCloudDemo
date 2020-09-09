package org.crystal.Client.dao;

import java.util.List;

import org.crystal.Client.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

	List<Employees> findByEmpNo(Integer empNo);

}

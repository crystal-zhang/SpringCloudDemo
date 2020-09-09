package org.crystal.Client.dao;

import org.crystal.Client.entity.UserBalance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserBalanceRepository extends CrudRepository<UserBalance, Integer> {

}

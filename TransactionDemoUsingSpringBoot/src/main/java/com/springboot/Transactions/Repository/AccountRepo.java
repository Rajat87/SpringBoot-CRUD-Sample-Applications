package com.springboot.Transactions.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Transactions.Model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}

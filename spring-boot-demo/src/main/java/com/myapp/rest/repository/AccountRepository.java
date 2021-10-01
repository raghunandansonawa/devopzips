package com.myapp.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.rest.models.Account;

// Spring Managed Bean

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	// select * from accounts where accountNumber=?
	Optional<Account> findByAccountNumber(String accountNumber);
	

}

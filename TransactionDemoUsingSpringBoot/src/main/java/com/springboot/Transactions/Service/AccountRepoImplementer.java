package com.springboot.Transactions.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.Transactions.Model.Account;
import com.springboot.Transactions.Repository.AccountRepo;

@Service
public class AccountRepoImplementer  {
	AccountRepo accountRepo;
	List<Account> accounts = new ArrayList<Account>() ;
	
	// Spring Boot will do dependency injection here
	public AccountRepoImplementer(AccountRepo accountRepo) {
		this.accountRepo=accountRepo;
	}
	
	public List<Account> addAccount(Account account) {
		accountRepo.save(account);
		return getAllAccounts();
	}
	
	public List<Account> deleteAccountById(long Id) {
		accountRepo.deleteById(Id);
		return getAllAccounts();
	}
	
	public List<Account> updateAccount(long accountId, Account account) {
		for(Account account2 : getAllAccounts()) {
			if(account2.getAccountId()==accountId) {
				accountRepo.save(account);
			}
		}
		return getAllAccounts();
	}
	
	public List<Account> getAllAccounts() {
		return accountRepo.findAll(Sort.by(Sort.Direction.ASC,"accountId")); // This will give me sorted results based on the instance variable that I have passed
		//return accountRepo.findAll();
	}
	
	// Will need to send two objects from RequestBody and then the amount from the path variable or request param
	@Transactional
	public List<Account> TransferMoney(Account from, Account to, long amount) {
		/*
		 * 
		 */
		if(from.getAmount()>=amount) {
			from.setAmount(from.getAmount()-amount);
			to.setAmount(to.getAmount()+amount);
			updateAccount(from.getAccountId(), from);
			updateAccount(to.getAccountId(), to);
			//throw new RuntimeException();
		}
		//else throw new RuntimeException();
		return getAllAccounts();
	}
	
	public Account getSingleAccount(long accountId) {
		for(Account account : getAllAccounts()) {
			if(account.getAccountId()==accountId) {
				return account;
			}
		}
		System.out.println("Outside Loop");
		throw new ResourceNotFoundException();
		
	}
	
}

	


// This will define all the methods which will affect the DB. But how will the object of this be initialized
// So this is actually the service which is implementing all the methods
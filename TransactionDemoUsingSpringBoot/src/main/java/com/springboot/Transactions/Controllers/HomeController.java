package com.springboot.Transactions.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Transactions.Model.Account;
import com.springboot.Transactions.Service.AccountRepoImplementer;

@RestController
public class HomeController {
	AccountRepoImplementer accountRepoImplementer;
	// Probably don't need to write @Autowire here. Spring should inject the dependency
	public HomeController(AccountRepoImplementer accountRepoImplementer) {
		this.accountRepoImplementer=accountRepoImplementer;
	}
	
	/*
	 * First I will create a account class
	 * It will hold the ID, name and the balance
	 * I will give normal methods to add a account, delete, get all accounts, get account by Id, 
	 * There will be a special method for transferring money between two accounts which will be annotated with the @Transactional annotation
	 */
	
	
	@GetMapping("/home/getAllAccounts")
	public ResponseEntity<List<Account>> getAllAccounts(){
		// Using response Entity to return a list of Accounts with our own status code
		return new ResponseEntity<List<Account>>( accountRepoImplementer.getAllAccounts(),HttpStatus.ACCEPTED);
	}
		
	@PostMapping("/home/addAccount")
	// The conversion of JSON is done by Jackson which is provided by spring boot
	public ResponseEntity<List<Account>> addAccount(@Valid @RequestBody Account account , BindingResult bindingResult){
		System.out.println("Inside This");
		return new ResponseEntity<List<Account>>( accountRepoImplementer.addAccount(account),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/home/updateAccount")
	public ResponseEntity<List<Account>> updateAccount(@RequestParam("AccountId") long accountId, @RequestBody Account account ){
		return new ResponseEntity<List<Account>>(accountRepoImplementer.updateAccount(accountId, account),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/home/deleteAccount")
	public ResponseEntity<List<Account>> deleteAccount(@RequestParam("accountId") long accountId){
		return new ResponseEntity<List<Account>>(accountRepoImplementer.deleteAccountById(accountId),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/home/transferAmount")
	public ResponseEntity<List<Account>> transferAmount(@RequestParam("amount") long amount, @RequestBody List<Account> fromTo){
		System.out.println("Inside This");
		Account from = fromTo.get(0);
		Account to = fromTo.get(1);
		return new ResponseEntity<List<Account>>(accountRepoImplementer.TransferMoney(from, to, amount),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/home/GetSingleAccount")
	public ResponseEntity<Account> returnAccountById(@RequestParam("accountId") long accountId){
		return new ResponseEntity<Account>(accountRepoImplementer.getSingleAccount(accountId),HttpStatus.ACCEPTED);
	}
	
	/*
	 * Okay so I have created a Transactional application
	 * But the next thing is that I have to create custom exceptions to handle invalid data
	 */
	
	
	
}

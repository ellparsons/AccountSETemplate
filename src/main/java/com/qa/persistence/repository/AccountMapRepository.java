package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	Map<Long, Account> account = new HashMap<>();

	JSONUtil util = new JSONUtil();
	
	public String getAllAccounts() {
		 
		return util.getJSONForObject(account);
	} 
 
	public String createAccount(String accountIn) {
		
		Account anAccount;
		anAccount = util.getObjectForJSON(accountIn, Account.class);
		this.account.put(anAccount.getAccountNumber(), anAccount);
		
		return "Created Account";
	}  
 
	public String deleteAccount(Long id) {
		 
		if (account != null) {   
			account.remove(id);
			return("Account successfully deleted");
			}
		else {
			return("Error: No account exists"); 		}
	}   

	public String updateAccount(Long id, String account) {
		
		Account anAccount = util.getObjectForJSON(account, Account.class);
		this.account.put(id, anAccount);
		return util.getJSONForObject(anAccount);
		
	}

}

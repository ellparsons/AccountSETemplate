package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository{
	
	Map<Long, Account> account = new HashMap<Long, Account>();
	
	@Inject
	JSONUtil util;
	 
	public String getAllAccounts() {
		 
		return util.getJSONForObject(account);
	}  
 
	public String createAccount(String accountIn) {
		 
		Account anAccount = util.getObjectForJSON(accountIn, Account.class);
		this.account.put(anAccount.getAccountNumber(), anAccount);
		return util.getJSONForObject(anAccount); 
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

	public long accountCount(String name) {
		int count = 0; 
		for (Long key : account.keySet()) {
			if (account.get(key).getFirstName().equals(name)) {
				count++;
			} 
		} 
		return count;
	}

	public String findAnAccount(Long id) {
		 
		return util.getJSONForObject(account.get(id));
	}
}

package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.persistence.util.JSONUtil;

public class BusinessRules implements BusinessRepository {
	
	@Inject
	private AccountRepository accRepo;
	
	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
	
		return accRepo.getAllAccounts();		
	}

	public String createAccount(String account) {
		
		Account anAccount;
		anAccount = util.getObjectForJSON(account, Account.class);
		if(anAccount.getAccountNumber()==9) {
			return ("This account is blocked");
		}
		else {
			accRepo.createAccount(account);
			return("Account created");
		}
	}
xx
	public String deleteAccount(Long id) {
		
		return accRepo.deleteAccount(id);
	}

	public String updateAccount(Long id, String account) {

		return accRepo.updateAccount(id, account);
	}

}

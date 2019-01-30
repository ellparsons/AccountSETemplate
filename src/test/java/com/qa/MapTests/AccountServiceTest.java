package com.qa.MapTests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.util.JSONUtil;

public class AccountServiceTest {

	JSONUtil js = new JSONUtil();
	AccountMapRepository accounts = new AccountMapRepository();
	
	@Before
	public void setup() {
		
	}
	  
	@Test
	public void addAccountTest() {
		Account account = new Account("test","test",1);
		
		String newAccount = js.getJSONForObject(account);
		 
		accounts.createAccount(newAccount);  
		
		account = js.getObjectForJSON(newAccount, Account.class);
		
		assertEquals("Account created",1, account.getAccountNumber());
		 
	} 
	  
	@Test
	public void add2AccountTest() {
		
		Account account1 = new Account("test","test",1);
		Account account2 = new Account("test1","test2",2);
		
		String newAccount1 = js.getJSONForObject(account1);
		String newAccount2 = js.getJSONForObject(account2);
		
		accounts.createAccount(newAccount1);  
		accounts.createAccount(newAccount2);  
		
		assertEquals("Account 1 created",1, account1.getAccountNumber());
		accounts.deleteAccount(1l);
		
		assertEquals("Account 2 created",2, account2.getAccountNumber()); 
		accounts.deleteAccount(2l);
	} 

	@Test
	public void removeAccountTest() {
		
		Account account1 = new Account("test","test",1);
		
		String newAccount1 = js.getJSONForObject(account1);
		
		accounts.createAccount(newAccount1);  
		
		accounts.deleteAccount(1l);  
		  
		assertEquals("Account deleted","{}",accounts.getAllAccounts());
	} 
	
	@Test
	public void remove2AccountTest() {
		
		Account account1 = new Account("test","test",1);
		Account account2 = new Account("test1","test2",2);
		
		String newAccount1 = js.getJSONForObject(account1);
		String newAccount2 = js.getJSONForObject(account2);
		
		accounts.createAccount(newAccount1); 
		accounts.createAccount(newAccount2);
		
		accounts.deleteAccount(1l);   
		accounts.deleteAccount(2l);  
		  
		assertEquals("Account deleted","{}",accounts.getAllAccounts());
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		
	}
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
	
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
	
	}

	@Test
	public void accountConversionToJSONTest() {
		
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		Account account = new Account("Bob","Smith",7);
		String newAccount = js.getJSONForObject(account);
		accounts.createAccount(newAccount); 
		
		assertEquals(0,accounts.accountCount("John"));   
		accounts.deleteAccount(1l);  
	}   
	    
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		Account account = new Account("John","Smith",7);   
		String newAccount = js.getJSONForObject(account);
		accounts.createAccount(newAccount); 
		
		assertEquals(1,accounts.accountCount("John"));
		accounts.deleteAccount(1l);  
	}
 
	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		Account account = new Account("John","Smith",1);
		Account account1 = new Account("John","Smith",2);
		
		String newAccount = js.getJSONForObject(account);
		String newAccount1 = js.getJSONForObject(account1);
		
		accounts.createAccount(newAccount); 
		accounts.createAccount(newAccount1); 
		
		assertEquals(2,accounts.accountCount("John"));
		accounts.deleteAccount(1l);   
		accounts.deleteAccount(2l);  
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		
	}

}

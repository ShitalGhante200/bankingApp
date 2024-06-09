package com.spring.banking_app.service;

import java.util.List;

import com.spring.banking_app.dto.AccountDto;


public interface AccountService {

	AccountDto createAccount (AccountDto account);

	AccountDto getAccountbyId(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(long id);
	
	
}
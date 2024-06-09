package com.spring.banking_app.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.spring.banking_app.dto.AccountDto;
import com.spring.banking_app.entity.Account;
import com.spring.banking_app.mapper.AccountMapper;
import com.spring.banking_app.repository.AccountRepository;
import com.spring.banking_app.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		 Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	
	public AccountDto getAccountbyId(Long id) {
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient amount");
		}
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount =  accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
		        .collect(Collectors.toList());
		 
	}



	@Override
	public void deleteAccount(long id) {
		
		Account account= accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exits"));
		
		accountRepository.deleteById(id);
	}

}

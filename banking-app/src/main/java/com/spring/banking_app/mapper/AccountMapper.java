package com.spring.banking_app.mapper;

import com.spring.banking_app.dto.AccountDto;
import com.spring.banking_app.entity.Account;


public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
			accountDto.getId(),
			accountDto.getAccountHolderName(),
			accountDto.getBalance()
			);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAcoountHolderName(),
				account.getBalance()
				);
		
		return accountDto;
		
	}

}

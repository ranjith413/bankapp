package com.bankapp.service;

import com.bankapp.dto.AccountBalanceDto;
import com.bankapp.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {


    public Account addAccount(Account account);

    public List<Account> getAllAccounts();

   public Account getAccountById(int id);

    public String transferFunds(int from,int to,double amount);

    public AccountBalanceDto getBalanceOf(int accountNumber);

    public String deleteAccount(int accountNumber);

    public String deposit(int accountNumber, double amount);
}

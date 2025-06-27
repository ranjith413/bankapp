package com.bankapp.service;

import com.bankapp.dto.AccountBalanceDto;
import com.bankapp.entity.Account;
import com.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(int id){
        return accountRepository.findById(id).orElse(null);
    }


    @Override
    public String transferFunds(int from, int to, double amount) {
        Account sender = accountRepository.findById(from).orElse(null);
        Account receiver = accountRepository.findById(to).orElse(null);

        if (sender == null || receiver == null) {
            return "ID MISMATCH";
        } else if (sender.getAccountBalance() < amount) {
            return "INSUFFICIENT FUNDS";
        } else {
            double senderBalance = sender.getAccountBalance();
            double receiverBalance = receiver.getAccountBalance();

            receiverBalance = receiverBalance + amount;
            senderBalance = senderBalance - amount;

            sender.setAccountBalance(senderBalance);
            receiver.setAccountBalance(receiverBalance);
            accountRepository.save(sender);
            accountRepository.save(receiver);
            return "SUCCESS";
        }
    }

    @Override
    public AccountBalanceDto getBalanceOf(int accountNumber) {
        Account acc = this.getAccountById(accountNumber);

        AccountBalanceDto accountBalanceDto = new AccountBalanceDto();
        if(acc == null)
            return null;
        else{
            accountBalanceDto.setAccountNumber(acc.getAccountNumber());
            accountBalanceDto.setAccountType(acc.getAccountType());
            accountBalanceDto.setBalance(acc.getAccountBalance());
            return accountBalanceDto;
        }
    }

    @Override
    public String deleteAccount(int accountNumber) {
        try {
            accountRepository.deleteById(accountNumber);
            return "account deleted successfully!";
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String deposit(int accountNumber, double amount) {
        Account acc = accountRepository.findById(accountNumber).orElse(null);

        if(acc != null){
            double updateBalance = acc.getAccountBalance();
            updateBalance += amount;
            acc.setAccountBalance(updateBalance);
            accountRepository.save(acc);
            return "Deposited "+amount+" successfully!";
        }
        else return null;

    }


}

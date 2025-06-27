package com.bankapp.service;

import com.bankapp.dto.AccountBalanceDto;
import com.bankapp.entity.Account;
import com.bankapp.entity.Customer;
import com.bankapp.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl serviceUnderTest;

    //defined Object of Account here to use for different tests
    Account acc = new Account(1, "SAVINGS", 1000.0, new Customer());

    @Test
    void getAllAccountsTest(){


        Customer cust1 = new Customer(1,"Ranjith","12345678","ranjith@email.com","Hyd");
        Account acc1 = new Account(1, "SAVINGS", 1000.0, cust1);

        Customer cust2 = new Customer(2,"Ravi","12345678","ravi@email.com","Hyd");
        Account acc2 = new Account(1, "SAVINGS", 1000.0, cust2);

        given(accountRepository.findAll()).willReturn(List.of(acc1,acc2));

        var accountList = serviceUnderTest.getAllAccounts();

        assertThat(accountList).isNotNull();
        assertThat(accountList.size()).isEqualTo(2);

    }

    @Test
    void getAccountByIdTest(){

        //Account acc = new Account(1, "SAVINGS", 1000.0, new Customer());

        //when(accountRepository.findById(1)).thenReturn(Optional.of(acc));

        given(accountRepository.findById(1)).willReturn(Optional.of(acc));

        Object acc1 = serviceUnderTest.getAccountById(1);
        assertThat(acc1).isEqualTo(acc);
    }

    @Test
    void addAccountTest(){

        when(accountRepository.save(acc)).thenReturn(acc);
        Account a = serviceUnderTest.addAccount(acc);
        assertThat(a).isEqualTo(acc);

    }

   @Test
    void getBalanceTest(){
        when(accountRepository.findById(1)).thenReturn(Optional.of(acc));
        AccountBalanceDto accountBalanceDto = serviceUnderTest.getBalanceOf(1);
        assertEquals(1000.0, accountBalanceDto.getBalance());
    }

    @Test
    void SuccessTransferFundsTest(){

        when(accountRepository.findById(1)).thenReturn(Optional.of(new Account(1, "SAVINGs", 1000.0, new Customer())));
        when(accountRepository.findById(2)).thenReturn(Optional.of(new Account(2, "SAVINGS", 1000.0, new Customer())));

        String response = serviceUnderTest.transferFunds(1,2,500);

        assertEquals("SUCCESS",response);
    }

    @Test
    void InsufficientFundsTest(){

        when(accountRepository.findById(1)).thenReturn(Optional.of(new Account(1, "SAVINGs", 1000.0, new Customer())));
        when(accountRepository.findById(2)).thenReturn(Optional.of(new Account(2, "SAVINGS", 1000.0, new Customer())));

        String response = serviceUnderTest.transferFunds(1,2,1500);

        assertEquals("INSUFFICIENT FUNDS",response);
    }

    void deleteAccountTest(){


    }


}

package com.bankapp.controller;

import com.bankapp.dto.AccountBalanceDto;
import com.bankapp.dto.CreateAccountDto;
import com.bankapp.dto.CustomerDto;
import com.bankapp.entity.Account;
import com.bankapp.entity.Customer;
import com.bankapp.service.AccountService;
import com.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    @PostMapping("/createAccount")
    public ResponseEntity<String> addAccount(@RequestBody CreateAccountDto createAccountDto){

        Account account = new Account();
        account.setAccountType(createAccountDto.getAccountType());
        account.setAccountBalance(createAccountDto.getInitialBalance());

        account = accountService.addAccount(account);

        Customer customer = new Customer();
        customer.setCustomerName(createAccountDto.getCustomerName());
        customer.setCustomerMobileNo(createAccountDto.getCustomerMobileNo());
        customer.setCustomerEmail(createAccountDto.getCustomerEmail());
        customer.setCustomerAddress(createAccountDto.getCustomerAddress());
        customer.setAccount(account);

        customerService.addCustomer(customer);

        return new ResponseEntity<>("accountNumber is: "+account.getAccountNumber(), HttpStatus.CREATED);
    }

    @GetMapping("/getAccountById/{accountNumber}")
    public ResponseEntity<Account> getAccountById(@PathVariable int accountNumber){
        Account acc = accountService.getAccountById(accountNumber);
        if(acc != null)
            return new ResponseEntity<>(acc, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }


    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<Account>> getAllAcoounts(){
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/transferFunds")
    public ResponseEntity<String> transferFunds(@RequestParam int from,
                                                @RequestParam int to,
                                                @RequestParam double amount){
        String response = accountService.transferFunds(from, to, amount);
        if(response.equals("ID MISMATCH"))
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        else if(response.equals("INSUFFICIENT FUNDS"))
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getBalance/{accountNumber}")
    public ResponseEntity<AccountBalanceDto> getBalance(@PathVariable int accountNumber){
        AccountBalanceDto accDto = accountService.getBalanceOf(accountNumber);
        if(accDto == null)
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(accDto, HttpStatus.OK);
    }

    @PutMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam int accountNumber, @RequestParam double amount){
        String response = accountService.deposit(accountNumber, amount);
        if(response == null)
        return new ResponseEntity<>("Account not found!",HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId){
        String response = customerService.deleteCustomer(customerId);
        if (response != null)
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("Customer Not Found!", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<String> updateCustomerDetails(@PathVariable int customerId,
                                        @RequestBody CustomerDto customerDto){

        String response = customerService.updateCustomerdetails(customerId,customerDto);
        if(response != null)
            return new ResponseEntity<>(response,HttpStatus.OK);
        else
            return new ResponseEntity<>("Customer Not Found!", HttpStatus.NOT_FOUND);



    }

}

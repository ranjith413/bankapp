package com.bankapp.service;

import com.bankapp.dto.CustomerDto;
import com.bankapp.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public void addCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public String updateCustomerdetails(int customerId, CustomerDto customerDto);

    public String deleteCustomer(int customerId);


}

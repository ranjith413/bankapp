package com.bankapp.service;

import com.bankapp.dto.CustomerDto;
import com.bankapp.entity.Customer;
import com.bankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public String updateCustomerdetails(int customerId, CustomerDto customerDto) {
        Customer updatedcustomer = customerRepository.findById(customerId).orElse(null);

        if(updatedcustomer == null)
            return null;
        else {
            updatedcustomer.setCustomerName(customerDto.getCustomerName());
            updatedcustomer.setCustomerMobileNo(customerDto.getCustomerMobileNo());
            updatedcustomer.setCustomerEmail(customerDto.getCustomerEmail());
            updatedcustomer.setCustomerAddress(customerDto.getCustomerAddress());

            customerRepository.save(updatedcustomer);
            return "Customer updated successfully!";
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
       Customer c = customerRepository.findById(customerId).orElse(null);

        if(c == null)
            return null;
        else {
            customerRepository.deleteById(customerId);
            return "Customer deleted Successfully!";
        }

    }
}

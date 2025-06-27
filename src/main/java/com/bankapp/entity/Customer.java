package com.bankapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String customerMobileNo;
    private String customerEmail;
    private String customerAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountNumber")
    @JsonIgnoreProperties("customer")
    private Account account;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerMobileNo, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobileNo = customerMobileNo;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Customer(int customerId, String customerName, String customerMobileNo, String customerEmail, String customerAddress, Account account) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobileNo = customerMobileNo;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.account = account;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNo() {
        return customerMobileNo;
    }

    public void setCustomerMobileNo(String customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerMobileNo='" + customerMobileNo + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", account=" + account +
                '}';
    }
}

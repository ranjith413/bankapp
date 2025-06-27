package com.bankapp.dto;

public class CreateAccountDto {

    private String customerName;
    private String customerMobileNo;
    private String customerEmail;
    private String customerAddress;
    private String accountType;
    private double initialBalance;

    public CreateAccountDto() {
    }

    public CreateAccountDto(String customerName, String customerMobileNo, String customerEmail, String customerAddress, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.customerMobileNo = customerMobileNo;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "CreateAccountDto{" +
                "customerName='" + customerName + '\'' +
                ", customerMobileNo='" + customerMobileNo + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", accountType='" + accountType + '\'' +
                ", initialBalance='" + initialBalance + '\'' +
                '}';
    }
}

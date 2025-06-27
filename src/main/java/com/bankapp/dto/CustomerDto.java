package com.bankapp.dto;

public class CustomerDto {

    private String customerName;
    private String customerMobileNo;
    private String customerEmail;
    private String customerAddress;


    public CustomerDto() {
    }

    public CustomerDto(String customerName, String customerMobileNo, String customerEmail, String customerAddress) {
        this.customerName = customerName;
        this.customerMobileNo = customerMobileNo;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
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

    @Override
    public String toString() {
        return "updateCustomerDto{" +
                "customerName='" + customerName + '\'' +
                ", customerMobileNo='" + customerMobileNo + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}

package com.filedroute.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CustomerRemote extends Customer{

    private Long CustomerNumber;
    private String CustomerName;
    private String CustomerCity;
    private String CustomerState;
    private String CustomerZipCode;


    public Long getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerCity() {
        return CustomerCity;
    }

    public void setCustomerCity(String customerCity) {
        CustomerCity = customerCity;
    }

    public String getCustomerState() {
        return CustomerState;
    }

    public void setCustomerState(String customerState) {
        CustomerState = customerState;
    }

    public String getCustomerZipCode() {
        return CustomerZipCode;
    }

    public void setCustomerZipCode(String customerZipCode) {
        CustomerZipCode = customerZipCode;
    }

    @Override
    public String toString() {
        return "CustomerRemote{" +
                "CustomerNumber=" + CustomerNumber +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerCity='" + CustomerCity + '\'' +
                ", CustomerState='" + CustomerState + '\'' +
                ", CustomerZipCode='" + CustomerZipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRemote that = (CustomerRemote) o;
        return Objects.equals(CustomerNumber, that.CustomerNumber) && Objects.equals(CustomerName, that.CustomerName) && Objects.equals(CustomerCity, that.CustomerCity) && Objects.equals(CustomerState, that.CustomerState) && Objects.equals(CustomerZipCode, that.CustomerZipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustomerNumber, CustomerName, CustomerCity, CustomerState, CustomerZipCode);
    }

    public CustomerRemote(Long customerNumber, String customerName, String customerCity, String customerState, String customerZipCode, LocalDateTime dateUpdated) {
        CustomerNumber = customerNumber;
        CustomerName = customerName;
        CustomerCity = customerCity;
        CustomerState = customerState;
        CustomerZipCode = customerZipCode;
        this.setDateUpdated(dateUpdated);
    }
}

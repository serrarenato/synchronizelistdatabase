package com.filedroute.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CustomerLocal extends Customer {
    private Long customerID;
    private String fname;
    private String lname;
    private String city;
    private String state;
    private String zipCode;


    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "CustomerLocal{" +
                "customerID=" + customerID +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerLocal that = (CustomerLocal) o;
        return Objects.equals(customerID, that.customerID) && Objects.equals(fname, that.fname) && Objects.equals(lname, that.lname) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, fname, lname, city, state, zipCode);
    }

    public CustomerLocal(Long customerID, String fname, String lname, String city, String state, String zipCode, LocalDateTime dateUpdated) {
        this.customerID = customerID;
        this.fname = fname;
        this.lname = lname;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.setDateUpdated(dateUpdated);
    }
}

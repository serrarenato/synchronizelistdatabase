package com.filedroute.entity;


import java.time.LocalDateTime;

public class Customer {
    private LocalDateTime dateUpdated;
    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }
    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}

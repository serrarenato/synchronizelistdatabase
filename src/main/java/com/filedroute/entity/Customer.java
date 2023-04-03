package com.filedroute.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Customer {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpdated;
    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }
    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}

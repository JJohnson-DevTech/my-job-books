package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NewJobDto {
    private int jobId;
    private String title;
    private String name;
    private String email;
    private String number;
    private String location;
    private LocalDateTime jobDate;
    private BigDecimal materialCost;
    private BigDecimal price;
    private int userId;

    public int getJobId() {
        return jobId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getJobDate() {
        return jobDate;
    }

    public void setJobDate(LocalDateTime jobDate) {
        this.jobDate = jobDate;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}

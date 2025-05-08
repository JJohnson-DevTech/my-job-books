package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Job {
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

    public Job() {
    }

    public Job(int jobId, String title, String name, String email, String number, String location, LocalDateTime jobDate, BigDecimal materialCost, BigDecimal price, int userId) {
        this.jobId = jobId;
        this.title = title;
        this.name = name;
        this.email = email;
        this.number = number;
        this.location = location;
        this.jobDate = jobDate;
        this.materialCost = materialCost;
        this.price = price;
        this.userId = userId;
    }
}

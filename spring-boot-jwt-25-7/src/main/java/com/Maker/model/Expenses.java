package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;


    @ManyToOne
    @JoinColumn(name = "daoUser_id",nullable = false)
    @JsonIgnore
    private DAOUser daoUser;

    private String daoUserName;

    private Date date;

    private float totalPrice;

    private String details;


    public Expenses(DAOUser daoUser, Date date, float totalPrice, String details) {
        this.daoUser = daoUser;
        this.daoUserName = daoUser.getFullName();
        this.date = date;
        this.totalPrice = totalPrice;
        this.details = details;
    }

    public Expenses() {
    }


    public DAOUser getDaoUser() {

        return daoUser;
    }

    public void setDaoUser(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public String getDaoUserName() {
        return daoUserName;
    }

    public void setDaoUserName(String daoUserName) {
        this.daoUserName = daoUserName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}

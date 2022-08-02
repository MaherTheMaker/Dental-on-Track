package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "daoUser_id",nullable = false)
    @JsonIgnore
    private DAOUser daoUser;

    @ManyToOne
    @JoinColumn(name = "moneySafe_id",nullable = false)
    @JsonIgnore
    private MoneySafe safeName;

    private Date date;
    private String userName;

    private String SafeName;

    private float payment;


    public Transaction(Date date, String userName, String SafeName, float payment) {
        this.date = date;
        this.userName = userName;
        this.SafeName = SafeName;
        this.payment = payment;
    }


    public Transaction() {
    }


    public DAOUser getDaoUser() {
        return daoUser;
    }

    public void setDaoUser(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public String getUserId() {
        return userName;
    }

    public void setUserId(String UserName) {
        userName = UserName;
    }

    public String getSafeId() {
        return SafeName;
    }

    public void setSafeId(String safeName) {
        this.SafeName = safeName;
    }



    public void setSafeName(MoneySafe safeName) {
        this.safeName = safeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSafeName() {
        return SafeName;
    }

    public void setSafeName(String safeName) {
        this.SafeName = safeName;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }
}

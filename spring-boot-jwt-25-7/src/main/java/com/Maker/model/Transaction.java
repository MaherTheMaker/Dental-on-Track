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
    private MoneySafe safe;

    private Date date;
    private String userName;

    private String safeName;


    public Transaction(Date date, String userName, String safeName) {
        this.date = date;
        this.userName = userName;
        this.safeName = safeName;
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
        return safeName;
    }

    public void setSafeId(String safeName) {
        this.safeName = safeName;
    }

    public MoneySafe getSafe() {
        return safe;
    }

    public void setSafe(MoneySafe safe) {
        this.safe = safe;
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
        return safeName;
    }

    public void setSafeName(String safeName) {
        this.safeName = safeName;
    }
}

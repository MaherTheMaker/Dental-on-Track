package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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


    private String userName;

    private String safeName;


    public Transaction(DAOUser daoUser, MoneySafe safe) {
        this.daoUser = daoUser;
        this.safe = safe;
        this.userName = daoUser.getUsername();
        this.safeName = safe.getName();
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
}

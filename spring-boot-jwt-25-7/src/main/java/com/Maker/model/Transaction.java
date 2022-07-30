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

    private int safeId;


    public Transaction(DAOUser daoUser, String userName, int safeId) {
        this.daoUser = daoUser;
        this.userName = userName;
        this.safeId = safeId;
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

    public int getSafeId() {
        return safeId;
    }

    public void setSafeId(int safeId) {
        this.safeId = safeId;
    }
}

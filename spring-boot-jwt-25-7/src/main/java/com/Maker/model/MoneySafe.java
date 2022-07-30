package com.Maker.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MoneySafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(mappedBy = "safe", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DAOUser> daoUsers ;


    private float balance;


    @OneToMany(mappedBy = "safe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactionList;


    public MoneySafe(List<DAOUser> daoUsers, float balance, List<Transaction> transactionList) {
        this.daoUsers = daoUsers;
        this.balance = balance;
        this.transactionList = transactionList;
    }


    public MoneySafe() {
    }

    public List<DAOUser> getDaoUsers() {
        return daoUsers;
    }

    public void setDaoUsers(List<DAOUser> daoUsers) {
        this.daoUsers = daoUsers;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }


    public int getId() {
        return id;
    }


}

package com.Maker.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class MoneySafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //todo one to one
    @OneToMany(mappedBy = "safe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DAOUser> daoUsers;

    private String type;

    private float balance = 0.0f;

    @OneToMany(mappedBy = "moneySafe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receipt> receipt;


    @OneToMany(mappedBy = "moneySafe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expenses> expenses;

    @OneToMany(mappedBy = "safe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactionList;


    public MoneySafe(String name, List<DAOUser> daoUsers, String type, float balance, List<Receipt> receipt, List<Transaction> transactionList) {
        this.name = name;
        this.daoUsers = daoUsers;
        this.type = type;
        this.balance = balance;
        this.receipt = receipt;
        this.transactionList = transactionList;
    }


    public MoneySafe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }


    public int getId() {
        return id;
    }

    public List<Receipt> getReceipt() {
        return receipt;
    }

    public void setReceipt(List<Receipt> receipt) {
        this.receipt = receipt;
    }
}

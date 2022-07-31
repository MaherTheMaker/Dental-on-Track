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

    @Column(nullable = false)
    private String daoUserName;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private float totalPrice;
    @Column(nullable = false)
    private String details;


    @Column(nullable = false)
    private String safeName;

    @ManyToOne
    @JoinColumn(name = "moneySafe_id",nullable = false)
    @JsonIgnore
    private MoneySafe moneySafe;

    public Expenses( String daoUserName, Date date, float totalPrice, String details,String safeName) {
        this.daoUserName = daoUserName;
        this.date = date;
        this.totalPrice = totalPrice;
        this.details = details;
        this.safeName = safeName;

    }
    public Expenses() {
    }

    public MoneySafe getMoneySafe() {
        return moneySafe;
    }

    public void setMoneySafe(MoneySafe moneySafe) {
        this.moneySafe = moneySafe;
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

    public String getSafeName() {
        return safeName;
    }

    public void setSafeName(String safeName) {
        this.safeName = safeName;
    }
}

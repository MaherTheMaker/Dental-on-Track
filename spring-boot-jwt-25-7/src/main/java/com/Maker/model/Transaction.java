package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @ManyToOne
   @JoinColumn(name = "moneySafe_id",nullable = false)
   @JsonIgnore
   private MoneySafe fromSafe;


   private LocalDate date ;


   @NotNull
   private float payment;

   @NotNull
   private String details;


   private String safeName;

    public Transaction(String details) {
        this.details = details;
    }


    public Transaction() {
    }


    public MoneySafe getFromSafe() {
        return fromSafe;
    }

    public void setFromSafe(MoneySafe fromSafe) {
        this.fromSafe = fromSafe;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
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

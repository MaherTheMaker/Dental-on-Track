package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String patientName;


    @Column(nullable = false)
    private String safeName;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;



    @ManyToOne
    @JoinColumn(name = "daoUser_id")
    @JsonIgnore
    private DAOUser daoUser;


    private Float Total;


    @ManyToOne
    @JoinColumn(name = "moneySafe_id")
    @JsonIgnore
    private MoneySafe moneySafe;

    private boolean isDiscount;



    private Date date;

    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ToothProcedure> procedure;


    public Receipt(String userName, String patientName, String safeName, Patient patient, DAOUser daoUser, Float total, MoneySafe moneySafe, boolean isDiscount, Date date, List<ToothProcedure> procedure) {
        this.userName = userName;
        this.patientName = patientName;
        this.safeName = safeName;
        this.patient = patient;
        this.daoUser = daoUser;
        Total = total;
        this.moneySafe = moneySafe;
        this.isDiscount = isDiscount;
        this.date = date;
        this.procedure = procedure;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean discount) {
        isDiscount = discount;
    }

    public Receipt() {
    }

    public String getUserName() {
        return userName;
    }


    public int getId() {
        return id;
    }

    public List<ToothProcedure> getProcedure() {
        return procedure;
    }

    public void setProcedure(List<ToothProcedure> procedure) {
        this.procedure = procedure;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public DAOUser getDaoUser() {
        return daoUser;
    }

    public void setDaoUser(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float total) {
        Total = total;
    }

    public MoneySafe getMoneySafe() {
        return moneySafe;
    }

    public void setMoneySafe(MoneySafe moneySafe) {
        this.moneySafe = moneySafe;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getSafeName() {
        return safeName;
    }

    public void setSafeName(String safeName) {
        this.safeName = safeName;
    }
}




package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    private String userName;

    private String patientName;


    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    @JsonIgnore
    private Patient patient;



    @ManyToOne
    @JoinColumn(name = "daoUser_id",nullable = false)
    @JsonIgnore
    private DAOUser daoUser;


    private Float Total;


    @ManyToOne
    @JoinColumn(name = "moneySafe_id",nullable = false)
    @JsonIgnore
    private MoneySafe moneySafe;


    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ToothProcedure> procedure ;


    public Receipt( Patient patient, DAOUser daoUser, Float total, MoneySafe moneySafe, List<ToothProcedure> procedure) {
        this.userName = daoUser.getUsername();
        this.patientName = patient.getFullName();
        this.patient = patient;
        this.daoUser = daoUser;
        Total = total;
        this.moneySafe = moneySafe;
        this.procedure = procedure;
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
}

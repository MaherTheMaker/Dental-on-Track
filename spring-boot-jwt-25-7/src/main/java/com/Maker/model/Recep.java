package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recep {

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


    private String details;

    public Recep( Patient patient, DAOUser daoUser, Float total, String details) {
        this.userName = daoUser.getUsername();
        this.patientName = patient.getFullName();
        this.patient = patient;
        this.daoUser = daoUser;
        Total = total;
        this.details = details;
    }

    public Recep() {
    }

    public String getUserName() {
        return userName;
    }

    public String getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }

    public void setDetails(String details) {
        this.details = details;
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
}

package com.Maker.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="patient_id")
    @JsonIgnore
    private Patient patient;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private Date date;



    //Todo how can declare a time
    @Column(nullable = false,unique = false)
    private int startTime;

    //Todo how can declare a time
    @Column(nullable = false,unique = false)
    private int endTime;

    @Column(length = 200)
    private String notes;



    public Appointment(Patient patient, Date date, int startTime, int endTime, String notes) {
        this.patient = patient;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.notes = notes;
    }

    public Appointment(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Appointment() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }






}

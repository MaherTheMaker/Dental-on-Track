package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ToothProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="patientTooth_id",nullable = false)
    private PatientTooth patientTooth;

    @ManyToOne
    @JoinColumn(name="myProcedure_id",nullable = false)
    private MyProcedure myProcedure;

    @ManyToOne
    @JoinColumn(name="treatmentPlan_id",nullable = false)
    @JsonIgnore
    private TreatmentPlan treatmentPlan;

    private float price;

    private boolean isDone=false;

    @Column(length = 200)
    private String notes;

    public ToothProcedure() {
    }

    public ToothProcedure(PatientTooth patientTooth, MyProcedure myProcedure, float price, boolean isDone, String notes) {
        this.patientTooth = patientTooth;
        this.myProcedure = myProcedure;
        this.price = price;
        this.isDone = isDone;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }



    public PatientTooth getPatientTooth() {
        return patientTooth;
    }

    public void setPatientTooth(PatientTooth patientTooth) {
        this.patientTooth = patientTooth;
    }

    public MyProcedure getProcedure() {
        return myProcedure;
    }

    public void setProcedure(MyProcedure myProcedure) {
        this.myProcedure = myProcedure;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TreatmentPlan getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }
}

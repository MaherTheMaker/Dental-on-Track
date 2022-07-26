package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
public class ToothProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="PatientTooth_id")
    private PatientTooth patientTooth;

    @ManyToOne
    @JoinColumn(name="procedure_id")
    private Procedures procedure;

    @ManyToOne
    @JoinColumn(name="treatmentPlan_id")
    @JsonIgnore
    private TreatmentPlan treatmentPlan;

    private float price;

    private boolean isDone=false;

    @Column(length = 200)
    private String notes;

    public ToothProcedure() {
    }

    public ToothProcedure(PatientTooth patientTooth, Procedures procedure, float price, boolean isDone, String notes) {
        this.patientTooth = patientTooth;
        this.procedure = procedure;
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

    public Procedures getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedures procedure) {
        this.procedure = procedure;
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
}

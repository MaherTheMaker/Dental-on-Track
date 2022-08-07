package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class MedHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="patient_id")
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="illness_id")
    private Illness illness;



    private String notes;

    public MedHistory(Patient patient, Illness illness, String notes) {
        this.patient = patient;
        this.illness = illness;
        this.notes = notes;
    }


    public MedHistory() {
    }



    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Illness getIllness() {
        return illness;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }
}

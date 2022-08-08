package com.Maker.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class PatientTooth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Todo Foreign keys with Tooth and patient

    private String toothId;

    private int patientId;

    public int getId() {
        return id;
    }

    @Column(length = 25)
    @Value("White")
    private String color="White";

    private ToothStatus status;

    @Column(length = 200)
    private String notes;


    public PatientTooth(String toothId, int patientId, String color, ToothStatus status, String notes) {
        this.toothId = toothId;
        this.patientId = patientId;
        this.color = color;
        this.status = status;
        this.notes = notes;
    }

    public PatientTooth() {
    }

    public String getToothId() {
        return toothId;
    }

    public void setToothId(String toothId) {
        this.toothId = toothId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ToothStatus getStatus() {
        return status;
    }

    public void setStatus(ToothStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}

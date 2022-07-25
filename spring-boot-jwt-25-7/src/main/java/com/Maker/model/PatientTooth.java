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

    private int toothId;

    private int patientId;

    //Todo convert into enum : Color and Status

    @Column(length = 25)
    @Value("White")
    private String color="White";

    @Column(length = 200)
    @Value("normal")
    private String status="Normal";

    @Column(length = 200)
    private String notes;


    public PatientTooth(int toothId, int patientId, String color, String status, String notes) {
        this.toothId = toothId;
        this.patientId = patientId;
//        this.color = color;
//        this.status = status;
//        this.notes = notes;
    }

    public PatientTooth() {
    }

    public int getToothId() {
        return toothId;
    }

    public void setToothId(int toothId) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

package com.Maker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class TreatmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


// Todo many to many ammar later (not that important)
    @ManyToOne
    @JoinColumn(name="patientTooth_id")
    @JsonIgnore
    private PatientTooth patientTooth;


    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne
    @JoinColumn(name="patient_id")
    @JsonIgnore
    private Patient patient;

    //Todo change to ToothProcedures.... done price

    @OneToMany(mappedBy = "treatmentPlan",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ToothProcedure> toothProcedures;





    private Date createdAt;

    private String notes;



    public TreatmentPlan() {
    }

//    public TreatmentPlan(PatientTooth patientTooth, List<Procedures> proceduresList, Date createdAt, String notes) {
//        this.patientTooth = patientTooth;
//        this.proceduresList = proceduresList;
//        this.createdAt = createdAt;
//        this.notes = notes;
//    }

//Todo remove Temp
    public TreatmentPlan(PatientTooth patientTooth, Patient patient, Date createdAt, String notes) {
        this.patientTooth = patientTooth;
        this.patient = patient;
        this.createdAt = createdAt;
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

//    public List<Procedures> getProceduresList() {
//        return proceduresList;
//    }
//
//    public void setProceduresList(List<Procedures> proceduresList) {
//        this.proceduresList = proceduresList;
//    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

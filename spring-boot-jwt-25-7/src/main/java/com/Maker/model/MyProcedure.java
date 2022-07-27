package com.Maker.model;

import javax.persistence.*;



@Entity
public class MyProcedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,length = 25,nullable = false)
    private String pName;








    private float defaultPrice;

    private int defaultNumberOfAppointments;

    private String notes;

    MyProcedure() {
    }

    MyProcedure(String pName, float defaultPrice, int defaultNumberOfAppointments, String notes) {
        this.pName = pName;
        this.defaultPrice = defaultPrice;
        this.defaultNumberOfAppointments = defaultNumberOfAppointments;
        this.notes = notes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public float getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public int getDefaultNumberOfAppointments() {
        return defaultNumberOfAppointments;
    }

    public void setDefaultNumberOfAppointments(int defaultNumberOfAppointments) {
        this.defaultNumberOfAppointments = defaultNumberOfAppointments;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

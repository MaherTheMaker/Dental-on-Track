package com.Maker.model;

import javax.persistence.*;

@Entity
public class Illness {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false,length = 25)
    private String name;

    @Column(nullable = false)
    private Gender gender;


    @Column(nullable = true ,length = 200)
    private String notes;

    public Illness() {
    }

    public Illness(String name, Gender gender, String notes) {
        this.name = name;
        this.gender = gender;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }
}

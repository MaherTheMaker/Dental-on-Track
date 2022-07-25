package com.Maker.model;

import javax.persistence.*;

@Entity
public class FireBaseToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(unique = true,length = 25,nullable = false)
    private String username;

    private String sToken;

    public FireBaseToken( ) {
    }

    public FireBaseToken(String username, String sToken) {
        this.username = username;
        this.sToken = sToken;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getsToken() {
        return sToken;
    }

    public void setsToken(String sToken) {
        this.sToken = sToken;
    }
}

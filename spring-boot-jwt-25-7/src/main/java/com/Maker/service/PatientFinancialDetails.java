package com.Maker.service;

import lombok.Data;

@Data
public
class PatientFinancialDetails {
    String patientName;
    float unpaid;
    float paid;


    public PatientFinancialDetails(String patientName, float unpaid, float paid) {
        this.patientName = patientName;
        this.unpaid = unpaid;
        this.paid = paid;
    }
}

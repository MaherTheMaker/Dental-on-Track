package com.Maker.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ReceiptForm {
   public String Username;
   public String safeName;
   public  String procedureName;
   public boolean discount;

   public Date date;
   public  float total;

    public ReceiptForm(String username, String safeName, String procedureName, Date date, float total) {
        Username = username;
        this.safeName = safeName;
        this.procedureName = procedureName;
        this.date = date;
        this.total = total;
    }

    public ReceiptForm() {
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getSafeName() {
        return safeName;
    }

    public void setSafeName(String safeName) {
        this.safeName = safeName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}

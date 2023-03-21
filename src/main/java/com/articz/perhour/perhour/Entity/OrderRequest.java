package com.articz.perhour.perhour.Entity;

public class OrderRequest {
    private String customername;
    private String customeremail;
    private  String phonenumber;

    private  double amount;


    public OrderRequest(String customername, String customeremail, String phonenumber, double amount) {
        this.customername = customername;
        this.customeremail = customeremail;
        this.phonenumber = phonenumber;
        this.amount = amount;
    }

    public OrderRequest() {
        super();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

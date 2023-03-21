package com.articz.perhour.perhour.Entity;




public class OrderResponse {
    private String secretkey;
    private String razorpayorderid;
    private String applicationfees;
    private String secretid;

    private String pgname;


    public OrderResponse(String secretkey, String razorpayorderid, String applicationfees, String secretid, String pgname) {
        this.secretkey = secretkey;
        this.razorpayorderid = razorpayorderid;
        this.applicationfees = applicationfees;
        this.secretid = secretid;
        this.pgname = pgname;
    }

    public OrderResponse() {
        super();
    }

    public String getSecretkey() {
        return secretkey;
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public String getRazorpayorderid() {
        return razorpayorderid;
    }

    public void setRazorpayorderid(String razorpayorderid) {
        this.razorpayorderid = razorpayorderid;
    }

    public String getApplicationfees() {
        return applicationfees;
    }

    public void setApplicationfees(String applicationfees) {
        this.applicationfees = applicationfees;
    }

    public String getSecretid() {
        return secretid;
    }

    public void setSecretid(String secretid) {
        this.secretid = secretid;
    }

    public String getPgname() {
        return pgname;
    }

    public void setPgname(String pgname) {
        this.pgname = pgname;
    }
}

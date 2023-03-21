package com.articz.perhour.perhour.Entity;

public class OrderRequest {
    private String customername;
    private String customeremail;
    private  String phonenumber;

    private  long amount;


    public OrderRequest(String customername, String customeremail, String phonenumber, long amount) {
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

package com.articz.perhour.perhour.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String shortdescription;
    private String fulldescription;

    private long price;

    private long totalbids;

    private LocalDate startdate;

    private LocalDate lastdate;

    private String timelimit;

    @OneToOne
    @JoinColumn(name = "givenby_id")
    private Users givenby;

    @OneToOne
    @JoinColumn(name = "givento_id")
    private Users givento;

    @OneToMany(mappedBy = "project")
    private List<Bids> bids;

    private boolean paymentdone;

    private String paymentid;

    private String paymentstatus;

    public Projects() {
        super();
    }

    public Projects(long id, String title, String shortdescription, String fulldescription, long price, long totalbids, LocalDate startdate, LocalDate lastdate, String timelimit, Users givenby, Users givento, boolean paymentdone, String paymentid, String paymentstatus) {
        this.id = id;
        this.title = title;
        this.shortdescription = shortdescription;
        this.fulldescription = fulldescription;
        this.price = price;
        this.totalbids = totalbids;
        this.startdate = startdate;
        this.lastdate = lastdate;
        this.timelimit = timelimit;
        this.givenby = givenby;
        this.givento = givento;
        this.paymentdone = paymentdone;
        this.paymentid = paymentid;
        this.paymentstatus = paymentstatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public String getFulldescription() {
        return fulldescription;
    }

    public void setFulldescription(String fulldescription) {
        this.fulldescription = fulldescription;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getTotalbids() {
        return totalbids;
    }

    public void setTotalbids(long totalbids) {
        this.totalbids = totalbids;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getLastdate() {
        return lastdate;
    }

    public void setLastdate(LocalDate lastdate) {
        this.lastdate = lastdate;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public Users getGivenby() {
        return givenby;
    }

    public void setGivenby(Users givenby) {
        this.givenby = givenby;
    }

    public Users getGivento() {
        return givento;
    }

    public void setGivento(Users givento) {
        this.givento = givento;
    }

    public boolean isPaymentdone() {
        return paymentdone;
    }

    public void setPaymentdone(boolean paymentdone) {
        this.paymentdone = paymentdone;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }
}

package com.articz.perhour.perhour.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Bids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "bidby_id")
    private Users bidby;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects project;


    private long price;

    private LocalDate biddate;

    private String biddescription;

    public Bids() {
        super();
    }

    public Bids(long id, Users bidby, Projects project, long price, LocalDate biddate, String biddescription) {
        this.id = id;
        this.bidby = bidby;
        this.project = project;
        this.price = price;
        this.biddate = biddate;
        this.biddescription = biddescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getBidby() {
        return bidby;
    }

    public void setBidby(Users bidby) {
        this.bidby = bidby;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public LocalDate getBiddate() {
        return biddate;
    }

    public void setBiddate(LocalDate biddate) {
        this.biddate = biddate;
    }

    public String getBiddescription() {
        return biddescription;
    }

    public void setBiddescription(String biddescription) {
        this.biddescription = biddescription;
    }
}

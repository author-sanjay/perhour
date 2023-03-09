package com.articz.perhour.perhour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Bids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "bidby_id")
    @JsonIgnore
    private Users bidby;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "project_id")
    private Projects project;


    private long userid;
    private long revisions;
    private long price;

    private String username;


    private long proposedtime;

    private LocalDate biddate;

    private String biddescription;

    public Bids() {
        super();
    }

    public Bids(long id, Users bidby, Projects project, long userid, long revisions, long price, String username, long proposedtime, LocalDate biddate, String biddescription) {
        this.id = id;
        this.bidby = bidby;
        this.project = project;
        this.userid = userid;
        this.revisions = revisions;
        this.price = price;
        this.username = username;
        this.proposedtime = proposedtime;
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

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getRevisions() {
        return revisions;
    }

    public void setRevisions(long revisions) {
        this.revisions = revisions;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getProposedtime() {
        return proposedtime;
    }

    public void setProposedtime(long proposedtime) {
        this.proposedtime = proposedtime;
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

package com.articz.perhour.perhour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private long price;

    private boolean montly;
    private long extendedbids;

    private long duration;


    @OneToMany(mappedBy = "membership")
    @JsonIgnore
    private List<Users> users;

    public Membership() {
        super();
    }

    public Membership(long id, String name, String description, long price, boolean montly, long extendedbids, long duration, List<Users> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.montly = montly;
        this.extendedbids = extendedbids;
        this.duration = duration;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isMontly() {
        return montly;
    }

    public void setMontly(boolean montly) {
        this.montly = montly;
    }

    public long getExtendedbids() {
        return extendedbids;
    }

    public void setExtendedbids(long extendedbids) {
        this.extendedbids = extendedbids;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}

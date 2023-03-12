package com.articz.perhour.perhour.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Helpandsupport {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  Users user;

   private LocalDate date;

   private String message;

private String status;
private String subject;

    public Helpandsupport(long id, Users user, LocalDate date, String message, String status, String subject) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.message = message;
        this.status = status;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Helpandsupport() {
        super();
    }
}

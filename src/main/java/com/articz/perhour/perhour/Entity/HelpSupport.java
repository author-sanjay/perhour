package com.articz.perhour.perhour.Entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HelpSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;

    private String subject;

    private String email;
    private String phone;

    private LocalDate date;

    private String status;

    @OneToOne
    @JoinColumn(name = "users_id")
    private  Users users;

    public HelpSupport(long id, String message, String subject, String email, String phone, LocalDate date, String status, Users users) {
        this.id = id;
        this.message = message;
        this.subject = subject;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.status = status;
        this.users = users;
    }

    public HelpSupport() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

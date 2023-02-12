package com.articz.perhour.perhour.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;
    private String lastname;
    private LocalDate dateofbirth;

    private String address;

    private String country;

    private String phone;

    private String email;

    private String username;

    private String password;

    private String role;

    private String bankname;

    private String accountnumber;

    private String ifsc;

    private String billingaddress;

    private float star;

    private LocalDate membershipexpiry;

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;


    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Users(long id, String firstname, String lastname, LocalDate dateofbirth, String address, String country, String phone, String email, String username, String password, String role, String bankname, String accountnumber, String ifsc, String billingaddress, float star, LocalDate membershipexpiry, Membership membership, Wallet wallet) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.bankname = bankname;
        this.accountnumber = accountnumber;
        this.ifsc = ifsc;
        this.billingaddress = billingaddress;
        this.star = star;
        this.membershipexpiry = membershipexpiry;
        this.membership = membership;
        this.wallet = wallet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public LocalDate getMembershipexpiry() {
        return membershipexpiry;
    }

    public void setMembershipexpiry(LocalDate membershipexpiry) {
        this.membershipexpiry = membershipexpiry;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}

package com.articz.perhour.perhour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;
    private String lastname;
    private String dateofbirth;

    private String address;

    private String country;

    private double totalstars;
    private String phone;

    private String email;

    private String username;

    private String password;

    private String role;

    private String bankingname;

    private String accountnumber;

    private String withdrawltype;

    private String billingaddress;

    private long bidsleft;

    private double star;

    private String headline;

    private double rates;

    private boolean ismember;

    private long membershipid;
    private LocalDate membershipexpiry;

    private String photo;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "membership_id")
    private Membership membership;





    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    public Wallet wallet;

    @OneToMany(mappedBy = "givento")
    @JsonIgnore
    private List<Projects> projects;

    private long priority;
    public Users() {
        super();
    }

    public Users(long id, String firstname, String lastname, String dateofbirth, String address, String country, double totalstars, String phone, String email, String username, String password, String role, String bankingname, String accountnumber, String withdrawltype, String billingaddress, long bidsleft, double star, String headline, double rates, boolean ismember, long membershipid, LocalDate membershipexpiry, String photo, Membership membership, Wallet wallet, List<Projects> projects, long priority) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.country = country;
        this.totalstars = totalstars;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.bankingname = bankingname;
        this.accountnumber = accountnumber;
        this.withdrawltype = withdrawltype;
        this.billingaddress = billingaddress;
        this.bidsleft = bidsleft;
        this.star = star;
        this.headline = headline;
        this.rates = rates;
        this.ismember = ismember;
        this.membershipid = membershipid;
        this.membershipexpiry = membershipexpiry;
        this.photo = photo;
        this.membership = membership;
        this.wallet = wallet;
        this.projects = projects;
        this.priority = priority;
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

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
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

    public double getTotalstars() {
        return totalstars;
    }

    public void setTotalstars(double totalstars) {
        this.totalstars = totalstars;
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

    public String getBankingname() {
        return bankingname;
    }

    public void setBankingname(String bankingname) {
        this.bankingname = bankingname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getWithdrawltype() {
        return withdrawltype;
    }

    public void setWithdrawltype(String withdrawltype) {
        this.withdrawltype = withdrawltype;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public long getBidsleft() {
        return bidsleft;
    }

    public void setBidsleft(long bidsleft) {
        this.bidsleft = bidsleft;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public boolean isIsmember() {
        return ismember;
    }

    public void setIsmember(boolean ismember) {
        this.ismember = ismember;
    }

    public long getMembershipid() {
        return membershipid;
    }

    public void setMembershipid(long membershipid) {
        this.membershipid = membershipid;
    }

    public LocalDate getMembershipexpiry() {
        return membershipexpiry;
    }

    public void setMembershipexpiry(LocalDate membershipexpiry) {
        this.membershipexpiry = membershipexpiry;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }
}

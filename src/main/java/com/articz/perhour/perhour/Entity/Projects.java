package com.articz.perhour.perhour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private long extend;
    private String shortdescription;
    private String fulldescription;

    private long price;

    private long totalbids;

    private LocalDate startdate;

    private LocalDate lastdate;

    private String timelimit;

    private LocalDate postedon;
    private String category;

    private  long assignedtoid;

    private String experience;

    @OneToOne
    @JoinColumn(name = "givenby_id")
    @JsonIgnore
    private Users givenby;

    private List<String> tags;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "givento_id")
    private Users givento;

    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<Bids> bids;

    private boolean paymentdone;

    private String paymentid;

    private boolean active;
    private String paymentstatus;

    private String status;
    private  String taggs;
    private boolean fixed;
    public Projects() {
        super();
    }


    public Projects(long id, String title, long extend, String shortdescription, String fulldescription, long price, long totalbids, LocalDate startdate, LocalDate lastdate, String timelimit, LocalDate postedon, String category, long assignedtoid, String experience, Users givenby, List<String> tags, Users givento, List<Bids> bids, boolean paymentdone, String paymentid, boolean active, String paymentstatus, String status, String taggs, boolean fixed) {
        this.id = id;
        this.title = title;
        this.extend = extend;
        this.shortdescription = shortdescription;
        this.fulldescription = fulldescription;
        this.price = price;
        this.totalbids = totalbids;
        this.startdate = startdate;
        this.lastdate = lastdate;
        this.timelimit = timelimit;
        this.postedon = postedon;
        this.category = category;
        this.assignedtoid = assignedtoid;
        this.experience = experience;
        this.givenby = givenby;
        this.tags = tags;
        this.givento = givento;
        this.bids = bids;
        this.paymentdone = paymentdone;
        this.paymentid = paymentid;
        this.active = active;
        this.paymentstatus = paymentstatus;
        this.status = status;
        this.taggs = taggs;
        this.fixed = fixed;
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

    public long getExtend() {
        return extend;
    }

    public void setExtend(long extend) {
        this.extend = extend;
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

    public LocalDate getPostedon() {
        return postedon;
    }

    public void setPostedon(LocalDate postedon) {
        this.postedon = postedon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getAssignedtoid() {
        return assignedtoid;
    }

    public void setAssignedtoid(long assignedtoid) {
        this.assignedtoid = assignedtoid;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Users getGivenby() {
        return givenby;
    }

    public void setGivenby(Users givenby) {
        this.givenby = givenby;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Users getGivento() {
        return givento;
    }

    public void setGivento(Users givento) {
        this.givento = givento;
    }

    public List<Bids> getBids() {
        return bids;
    }

    public void setBids(List<Bids> bids) {
        this.bids = bids;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaggs() {
        return taggs;
    }

    public void setTaggs(String taggs) {
        this.taggs = taggs;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}

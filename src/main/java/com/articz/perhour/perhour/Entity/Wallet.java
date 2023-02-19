package com.articz.perhour.perhour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  long balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "uid")
    public Users user;



@OneToMany(mappedBy = "wallet",cascade = CascadeType.ALL)
    private List<WalletTxn> txn;

    public Wallet() {
        super();
    }

    public Wallet(long id, long balance, Users user, List<WalletTxn> txn) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.txn = txn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<WalletTxn> getTxn() {
        return txn;
    }

    public void setTxn(List<WalletTxn> txn) {
        this.txn = txn;
    }
}

package com.articz.perhour.perhour.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  long balance;

@OneToOne
@JoinColumn(name = "users_id")
private Users users;



@OneToMany(mappedBy = "wallet",cascade = CascadeType.ALL)
    private List<WalletTxn> txn;

    public Wallet() {
        super();
    }

    public Wallet(long id, long balance, Users users, List<WalletTxn> txn) {
        this.id = id;
        this.balance = balance;
        this.users = users;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<WalletTxn> getTxn() {
        return txn;
    }

    public void setTxn(List<WalletTxn> txn) {
        this.txn = txn;
    }
}

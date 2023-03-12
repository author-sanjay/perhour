package com.articz.perhour.perhour.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class WalletTxn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float amount;

    private LocalDate date;

    private boolean incoming;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    @JsonIgnore
    private Wallet wallet;

    public WalletTxn() {
        super();
    }

    public WalletTxn(long id, float amount, LocalDate date, boolean incoming, Wallet wallet) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.incoming = incoming;
        this.wallet = wallet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isIncoming() {
        return incoming;
    }

    public void setIncoming(boolean incoming) {
        this.incoming = incoming;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}

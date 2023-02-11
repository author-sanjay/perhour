package com.articz.perhour.perhour.Dao;

import com.articz.perhour.perhour.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletDao extends JpaRepository<Wallet,Long> {
}

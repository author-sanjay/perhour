package com.articz.perhour.perhour.Dao;

import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTxnDao extends JpaRepository<WalletTxn,Long> {
}

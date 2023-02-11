package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WalletTxnService {
       public List<WalletTxn> getall();
        public WalletTxn add(WalletTxn txn,long id);
        public WalletTxn getsingledetail(long id);
        public List<WalletTxn> getsingle(String id);


    }


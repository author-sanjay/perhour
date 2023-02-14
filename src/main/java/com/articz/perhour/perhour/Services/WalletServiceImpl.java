package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.WalletDao;
import com.articz.perhour.perhour.Entity.Wallet;
import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WalletServiceImpl implements WalletService{

    @Autowired
    public WalletDao walletDao;


    @Override
    public long balance(long id) {
        Optional<Wallet> wallet=walletDao.findById(id);
        if(wallet.isPresent()){
            Wallet wallet1=wallet.get();
            return wallet1.getBalance();
        }
        return 0;
    }

    @Override
    public List<WalletTxn> gettxn(long id) {
        Optional<Wallet> wallet=walletDao.findById(id);
        if(wallet.isPresent()){
            Wallet wallet1=wallet.get();
         return wallet1.getTxn();
        }
        return null;
    }
}

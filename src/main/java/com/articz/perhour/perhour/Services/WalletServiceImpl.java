package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Dao.WalletDao;
import com.articz.perhour.perhour.Entity.Users;
import com.articz.perhour.perhour.Entity.Wallet;
import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    public WalletDao walletDao;
    @Autowired
    private UsersDao usersDao;


    @Override
    public long balance(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Wallet wallet1=users.get().getWallet();
            return wallet1.getBalance();
        }
        return 0;
    }

    @Override
    public List<WalletTxn> gettxn(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Wallet wallet1=users.get().getWallet() ;
         return wallet1.getTxn();
        }
        return null;
    }
}

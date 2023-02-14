package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Dao.WalletTxnDao;
import com.articz.perhour.perhour.Entity.Users;
import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WalletTxnServiceImpl implements WalletTxnService{

    @Autowired
    public WalletTxnDao walletTxnDao;

    @Autowired
    public UsersDao usersDao;


    @Override
    public List<WalletTxn> getall() {
        return walletTxnDao.findAll();
    }

    @Override
    public WalletTxn add(WalletTxn txn, long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Users users1=users.get();
            WalletTxn taxx=walletTxnDao.save(txn);
            List<WalletTxn> tx=users1.getWallet().getTxn();
            tx.add(taxx);
            users1.getWallet().setTxn(tx);
            usersDao.save(users1);
            return taxx;
        }
        return null;
    }

    @Override
    public WalletTxn getsingledetail(long id) {
        Optional<WalletTxn> txn=walletTxnDao.findById(id);
        if(txn.isPresent()){
            return txn.get();
        }
        return null;
    }

    @Override
    public List<WalletTxn> getsingle(long uid) {
        Optional<Users> users=usersDao.findById(uid);
        if(users.isPresent()){
            return users.get().getWallet().getTxn();
        }
        return null;
    }
}

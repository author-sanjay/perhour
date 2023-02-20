package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Dao.WalletDao;
import com.articz.perhour.perhour.Dao.WalletTxnDao;
import com.articz.perhour.perhour.Entity.Users;
import com.articz.perhour.perhour.Entity.Wallet;
import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WalletTxnServiceImpl implements WalletTxnService{

    @Autowired
    public WalletTxnDao walletTxnDao;

    @Autowired
    public UsersDao usersDao;
    @Autowired
    private WalletDao walletDao;


    @Override
    public List<WalletTxn> getall() {
        return walletTxnDao.findAll();
    }

    @Override
    public WalletTxn add(WalletTxn txn, long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Users users1=users.get();
            txn.setWallet(users1.getWallet());
            txn.setDate(LocalDate.now());
            WalletTxn taxx=walletTxnDao.save(txn);
            Wallet wal=users1.getWallet();
            List<WalletTxn> tx=wal.getTxn();
            tx.add(taxx);
            float balance=wal.getBalance();
            balance=balance+taxx.getAmount();
            wal.setBalance((long) balance);
            walletDao.save(wal);

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

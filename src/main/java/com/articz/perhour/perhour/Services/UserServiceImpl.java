package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.MembershipDao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public MembershipDao membershipDao;
    @Autowired
    public UsersDao usersDao;
    @Override
    public Users add(Users users) {
        Wallet wal=new Wallet();
        users.setWallet(wal);
        usersDao.save(users);
        return users;


    }

    @Override
    public Users update(Users users) {
        Optional<Users> users1=usersDao.findById(users.getId());
        if(users1.isPresent()){
            Users users2=users1.get();
            users2=users;
            usersDao.save(users2);
            return users2;
        }
        return null;
    }

    @Override
    public Users remove(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            usersDao.deleteById(users.get().getId());
            return  users.get();
        }
        return null;
    }

    @Override
    public Users get(long id) {
        Optional<Users> users= usersDao.findById(id);
        if(users.isPresent()){
            return users.get();
        }
        return null;
    }

    @Override
    public List<Users> getall() {

        return usersDao.findAll();
    }

    @Override
    public Users addMembership(long id, long membership)
    {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Users users1=users.get();
            Optional<Membership> membership1=membershipDao.findById(membership);
            if(membership1.isPresent()){
                users1.setMembership(membership1.get());
            }
            usersDao.save(users1);
            return users1;
        }

        return  null;
    }

    @Override
    public Users removeMembership(long id, long membership) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Users users1=users.get();
            users1.setMembership(null);
            usersDao.save(users1);
            return users1;
        }

        return null;
    }

    @Override
    public Projects getProject(long id, long project) {
        return null;
    }

    @Override
    public List<Projects> getallprojects(long id) {
        return null;
    }

    @Override
    public List<Projects> getactiveprojects(long id) {
        return null;
    }

    @Override
    public List<Projects> getCompleted(long id) {
        return null;
    }

    @Override
    public List<Projects> getcanceled(long id) {
        return null;
    }

    @Override
    public Projects addProject(long id, long project) {
        return null;
    }

    @Override
    public Projects updateProject(Projects project) {
        return null;
    }

    @Override
    public Projects updateProjectfreelancer(long id, Projects project) {
        return null;
    }

    @Override
    public Projects requestextend(long id, long project, long days) {
        return null;
    }

    @Override
    public Projects removeuser(long id, long project) {
        return null;
    }


    @Override
    public float readbalance(long id) {
        return 0;
    }

    @Override
    public WalletTxn add(long id, WalletTxn walletTxn) {
        return null;
    }

    @Override
    public List<WalletTxn> read(long id) {
        return null;
    }
}

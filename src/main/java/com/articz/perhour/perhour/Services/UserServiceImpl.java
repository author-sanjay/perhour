package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Bids;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Entity.Users;
import com.articz.perhour.perhour.Entity.WalletTxn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Users add(Users users) {
        return null;
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public Users remove(long id) {
        return null;
    }

    @Override
    public Users get(long id) {
        return null;
    }

    @Override
    public Users getall() {
        return null;
    }

    @Override
    public Users addMembership(long id, long membership) {
        return null;
    }

    @Override
    public Users removeMembership(long id, long membership) {
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

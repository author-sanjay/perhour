package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface UserService {

    public Users add(Users users);

    public Users update(Users users);

    public Users remove(long id);

    public Users get(long id);

    public Users getall();

    public Users addMembership(long id,long membership);

    public  Users removeMembership(long id,long membership);

    public Projects getProject(long id, long project);

    public List<Projects> getallprojects(long id);

    public List<Projects> getactiveprojects(long id);

    public List<Projects> getCompleted(long id);

    public List<Projects> getcanceled(long id);

    public Projects addProject(long id,long project);

    public Projects updateProject(Projects project);

    public Projects updateProjectfreelancer(long id,Projects project);

    public  Projects requestextend(long id, long project, long days);

    public Projects removeuser(long id,long project);



    //wallet balance
    public float readbalance(long id);

    public WalletTxn add(long id, WalletTxn walletTxn);

    public List<WalletTxn> read(long id);

}

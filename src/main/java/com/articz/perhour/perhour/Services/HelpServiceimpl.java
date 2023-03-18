package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.Helpdao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.HelpSupport;
import com.articz.perhour.perhour.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HelpServiceimpl implements  HelpService{

    @Autowired
    public Helpdao helpdao;
    @Autowired
    private UsersDao usersDao;


    @Override
    public HelpSupport add(HelpSupport hep, long id) {
        Optional<Users> user=usersDao.findById(id);
        if(user.isPresent()){
            hep.setDate(LocalDate.now());
            hep.setUsers(user.get());
            hep.setStatus("Active");

            return helpdao.save(hep);
        }
return null
        ;
    }

    @Override
    public HelpSupport getsingle(long id) {
        Optional<HelpSupport> h=helpdao.findById(id);
        if(h.isPresent()){
            return  h.get();
        }
        return  null;
    }

    @Override
    public List<HelpSupport> getactive() {
List<HelpSupport> h=helpdao.findAll();
        ArrayList<HelpSupport> active=new ArrayList<>();
        for(int i=0;i<h.size();i++){
            if(h.get(i).getStatus().equals("Active")){
                active.add(h.get(i));
            }
        }

        return  active;
    }

    @Override
    public HelpSupport update(HelpSupport helpService) {
        Optional<HelpSupport> h=helpdao.findById(helpService.getId());
        if(h.isPresent()){
            h.get().setStatus("Resolved");
        }
        return null;
    }

    @Override
    public HelpSupport withdrawl(HelpSupport hl,double amount, String method, String name, String ac, long uid) {
        Optional<Users> users=usersDao.findById(uid);
        if(users.isPresent()){

            hl.setUsers(users.get());
            hl.setStatus("Active");
            hl.setDate(LocalDate.now());
            hl.setSubject("Withdraw");
            hl.setMessage("Hi I want a withdrawl of Amount:"+amount+"in my "+method+ " account. My account number is:"+ac +" and my billing name is: "+name);
            return helpdao.save(hl);
        }

        return null;
    }

    @Override
    public HelpSupport resolved(long id) {
        Optional<HelpSupport> hp = helpdao.findById(id);
        if(hp.isPresent()){
            hp.get().setStatus("Resolved");
            helpdao.save(hp.get());
            return  hp.get();
        }
        return null;
    }
}

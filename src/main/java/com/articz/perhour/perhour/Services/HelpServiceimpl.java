package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.Helpdao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.Helpandsupport;
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
    public Helpandsupport add(Helpandsupport hep,long id) {
        Optional<Users> user=usersDao.findById(id);
        if(user.isPresent()){
            hep.setDate(LocalDate.now());
            hep.setUser(user.get());
            hep.setStatus("Active");

            return helpdao.save(hep);
        }
return null
        ;
    }

    @Override
    public Helpandsupport getsingle(long id) {
        Optional<Helpandsupport> h=helpdao.findById(id);
        if(h.isPresent()){
            return  h.get();
        }
        return  null;
    }

    @Override
    public List<Helpandsupport> getactive() {
List<Helpandsupport> h=helpdao.findAll();
        ArrayList<Helpandsupport> active=new ArrayList<>();
        for(int i=0;i<h.size();i++){
            if(h.get(i).getStatus().equals("Active")){
                active.add(h.get(i));
            }
        }

        return  active;
    }

    @Override
    public Helpandsupport update(Helpandsupport helpService) {
        Optional<Helpandsupport> h=helpdao.findById(helpService.getId());
        if(h.isPresent()){
            h.get().setStatus("Resolved");
        }
        return null;
    }

    @Override
    public Helpandsupport withdrawl(Helpandsupport hl,double amount, String method, String name, String ac, long uid) {
        Optional<Users> users=usersDao.findById(uid);
        if(users.isPresent()){

            hl.setUser(users.get());
            hl.setStatus("Active");
            hl.setDate(LocalDate.now());
            hl.setSubject("Withdraw");
            hl.setMessage("Hi I want a withdrawl of Amount:"+amount+"in my "+method+ " account. My account number is:"+ac +" and my billing name is: "+name);
            return helpdao.save(hl);
        }

        return null;
    }
}

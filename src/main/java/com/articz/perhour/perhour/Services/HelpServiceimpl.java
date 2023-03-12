package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.Helpdao;
import com.articz.perhour.perhour.Entity.Helpandsupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HelpServiceimpl implements  HelpService{

    @Autowired
    public Helpdao helpdao;


    @Override
    public Helpandsupport add(Helpandsupport hep) {

        return helpdao.save(hep);
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
}

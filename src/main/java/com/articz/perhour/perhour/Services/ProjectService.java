package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Projects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public Projects add(Projects project,long id) ;

    public Projects update(Projects project) ;

    public Projects delete(long project) ;

    public List<Projects> getall();

    public  Projects getsingle(long id);

    public Projects makepayment(long project);

    public List<Projects> bytags(String st);


}

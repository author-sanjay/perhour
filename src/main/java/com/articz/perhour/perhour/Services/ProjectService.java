package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Projects;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    public Projects add(Projects project) ;

    public Projects update(Projects project) ;

    public Projects delete(long project) ;

    public Projects makepayment(long project);


}

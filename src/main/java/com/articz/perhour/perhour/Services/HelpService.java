package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Helpandsupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HelpService {
    public Helpandsupport add(Helpandsupport hep, long id);
    public Helpandsupport getsingle(long id);
    public List<Helpandsupport > getactive();

    public Helpandsupport update(Helpandsupport helpService);

    public Helpandsupport withdrawl(Helpandsupport helpService,double amount, String method, String name, String ac, long uid);
}

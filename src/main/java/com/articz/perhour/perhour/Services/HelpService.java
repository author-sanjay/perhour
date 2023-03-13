package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.HelpSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HelpService {
    public HelpSupport add(HelpSupport hep, long id);
    public HelpSupport getsingle(long id);
    public List<HelpSupport > getactive();

    public HelpSupport update(HelpSupport helpService);

    public HelpSupport withdrawl(HelpSupport helpService,double amount, String method, String name, String ac, long uid);
}

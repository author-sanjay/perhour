package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Bids;
import com.articz.perhour.perhour.Entity.Membership;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MembershipService {

    public Membership add(Membership membership);

    // updatebid
    public Membership update(Membership membership);
    // deletedbid

    public Membership delete(long id);
    // readbid
    public List<Membership> readall();

    public Membership read(long id);

}

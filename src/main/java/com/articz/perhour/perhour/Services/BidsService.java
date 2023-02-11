package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Bids;
import org.springframework.stereotype.Service;

@Service
public interface BidsService {

    // add bid
    public Bids add(long id, Bids bid, long project);

    // updatebid
    public Bids update(long id, Bids bid,long project);
    // deletedbid

    public Bids delete(long id, long bid);
    // readbid
    public Bids read(long id, long project);
}

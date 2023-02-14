package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Bids;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BidsService {

    // add bid
    public Bids add(long id, Bids bid, long project);

    // updatebid
    public Bids update( Bids bid);
    // deletedbid

    public Bids delete(long id, long bid);
    // readbid
    public Bids readsingle(long id);


    public List<Bids> readforproject(long project);
}

package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Bids;

import com.articz.perhour.perhour.Services.BidsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidsController {

    @Autowired
    private BidsService bidsService;



//    done
    //add
    @PostMapping(path = "/add/{id}/{id2}")
    public Bids add(@RequestBody Bids bids, @PathVariable long id, @PathVariable long id2){
        return  this.bidsService.add(id,bids,id2);
    }


    //TODO do properly
    //getall

    @PostMapping(path = "/update")
    public Bids update(@RequestBody Bids bids){
        return  this.bidsService.update(bids);
    }


    //delete

//done
    @DeleteMapping(path = "/delete/{projectid}/{bidid}")
    public Bids delete(@PathVariable long projectid, @PathVariable long bidid){
        return  this.bidsService.delete(projectid, bidid);
    }



//    done
    //getprojectbids
    @GetMapping(path = "/getprojectbids/{id}")
    public List<Bids> getbids(@PathVariable long id){
        return  this.bidsService.readforproject(id);
    }



//    done
    //getsinglebid
    @GetMapping(path = "/getbid/{id}")
    public Bids getbid(@PathVariable long id){
        return  this.bidsService.readsingle(id);
    }
}

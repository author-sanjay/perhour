package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Bids;
import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Services.MembershipService;
import com.articz.perhour.perhour.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    public MembershipService membershipService;

    @Autowired
    public UserService userService;

    @PostMapping(path = "/add")
    public Membership add(@RequestBody Membership membership){
        return  this.membershipService.add(membership);
    }

    @PostMapping(path = "/update")
    public Membership update(@RequestBody Membership membership){
        return  this.membershipService.update(membership);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Membership delete(@PathVariable long id){
        return  this.membershipService.delete(id);
    }

    @GetMapping(path = "/getall")
    public List<Membership> getall(){
        return  this.membershipService.readall();
    }

    @GetMapping(path = "/getsingle/{id}")
    public Membership getsingle(@PathVariable long id){
        return  this.membershipService.read(id);
    }
}

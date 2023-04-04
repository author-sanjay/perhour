package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Bids;
import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Entity.Users;
import com.articz.perhour.perhour.Services.MembershipService;
import com.articz.perhour.perhour.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    public MembershipService membershipService;

    @Autowired
    public UserService userService;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(path = "/add")
    public Membership add(@RequestBody Membership membership){
        return  this.membershipService.add(membership);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(path = "/update")
    public Membership update(@RequestBody Membership membership){
        return  this.membershipService.update(membership);
    }



    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(path = "/delete/{id}")
    public Membership delete(@PathVariable long id){
        return  this.membershipService.delete(id);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/getall")
    public List<Membership> getall(){
        return  this.membershipService.readall();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(path = "/getusers/{id}")
    public List<Users> getusers(@PathVariable long id){
        return  this.membershipService.users(id);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/getsingle/{id}")
    public Membership getsingle(@PathVariable long id){
        return  this.membershipService.read(id);
    }
}

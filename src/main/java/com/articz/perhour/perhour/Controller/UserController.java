package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Entity.Users;
import com.articz.perhour.perhour.Entity.WalletTxn;
import com.articz.perhour.perhour.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    private Users add(@RequestBody Users users){
        return  this.userService.add(users);
    }

    @PostMapping("/update")
    private Users update(@RequestBody Users users){
        return  this.userService.update(users);
    }

    @DeleteMapping("/delete/{id}")
    private Users delete(@PathVariable long id){
        return  this.userService.remove(id);
    }


    @GetMapping("/getuser/{id}")
    private Users getUsers(@PathVariable long id){
        return  this.userService.get(id);
    }

    @GetMapping("/getall")
    private List<Users> getUsers(){
        return  this.userService.getall();
    }

    @PostMapping("/addmembership/{id}/{id2}")
    private Users addmembership(@PathVariable long users,@PathVariable long mem){
        return  this.userService.addMembership(users,mem);
    }

    @PostMapping("/removemembership/{id}/{id2}")
    private Users remove(@PathVariable long users,@PathVariable long mem){
        return  this.userService.removeMembership(users,mem);
    }

    @PostMapping("/checkmembership/{id}/{id2}")
    private Users check(@PathVariable long users,@PathVariable long mem){
        return  this.userService.checkMembership(users,mem);
    }

    @GetMapping("/getprojectdetails/{id}/{id2}")
    private Projects getproject(@PathVariable long users, @PathVariable long projects){
        return  this.userService.getProject(users,projects);
    }

    @GetMapping("/getallprojects/{id}")
    private List<Projects> getallpr(@PathVariable long users){
        return  this.userService.getallprojects(users);
    }

    @GetMapping("/getactiveprojects/{id}")
    private List<Projects> getactivepr(@PathVariable long users){
        return  this.userService.getactiveprojects(users);
    }

    @GetMapping("/getcancelledprojects/{id}")
    private List<Projects> getc(@PathVariable long users){
        return  this.userService.getcanceled(users);
    }

    @GetMapping("/getcompletedprojects/{id}")
    private List<Projects> getcomplpr(@PathVariable long users){
        return  this.userService.getCompleted(users);
    }

    @PostMapping("/addproject/{id}/{id2}")
    private Projects addpr(@PathVariable long users,@PathVariable long pr){
        return  this.userService.addProject(users,pr);
    }

    @PostMapping("/updatepr")
    private Projects update(@RequestBody Projects projects){
        return  this.userService.updateProject(projects);
    }

    @PostMapping("/extend/{id}/{id2}/{id3}")
    private Projects extend(@PathVariable long user,@PathVariable long pr,@PathVariable long days){
        return  this.userService.requestextend(user,pr,days);
    }

    @PostMapping("/removefromproject/{id}/{id2}")
    private Projects removefrompr(@PathVariable long user,@PathVariable long pr){
        return  this.userService.removeuser(user,pr);
    }

    @GetMapping("/balance/{id}")
    private float bal(@PathVariable long user){
        return  this.userService.readbalance(user);
    }

    @GetMapping("/gettxn/{id}")
    private List<WalletTxn> txns(@PathVariable long user){
        return  this.userService.read(user);
    }













}

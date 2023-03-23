package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Entity.Users;
import com.articz.perhour.perhour.Entity.WalletTxn;
import com.articz.perhour.perhour.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/verifyusername/{id}")
    private  boolean verufiyusername(@PathVariable String id){return  this.userService.verifyusername(id);}


    @PostMapping("/changepassword/{id}/{id2}")
    private  Users forgorpassword(@PathVariable long id,@PathVariable String id2){return  this.userService.resetpassword(id,id2);}


    //done
    @PostMapping("/add")
    private Users add(@RequestBody Users users){
        return  this.userService.add(users);
    }

    @PostMapping("/login/{id}/{id1}")
    private Users add(@PathVariable String id,@PathVariable String id1){
        return  this.userService.login(id,id1);
    }

    //done
    @PostMapping("/update")
    private Users update(@RequestBody Users users){
        return  this.userService.update(users);
    }


    //done
    @DeleteMapping("/delete/{id}")
    private Users delete(@PathVariable long id){
        return  this.userService.remove(id);
    }


    //done
    @GetMapping("/getuser/{id}")
    private Users getUsers(@PathVariable long id){
        return  this.userService.get(id);
    }


    @GetMapping("/gettop")
    private List<Users> top3(){
        List<Users> top3=userService.top3();
        return  top3;
    }

    @GetMapping("/gettop15")
    private List<Users> top15(){
        List<Users> top3=userService.top15();
        return  top3;
    }


    //done
    @GetMapping("/getall")
    private List<Users> getUsers(){
        return  this.userService.getall();
    }


    //done
    @PostMapping("/addmembership/{id}/{id2}")
    private Users addmembership(@PathVariable long id,@PathVariable long id2){
        return  this.userService.addMembership(id,id2);
    }



    //done
    @PostMapping("/removemembership/{users}/{mem}")
    private Users remove(@PathVariable long users,@PathVariable long mem){
        return  this.userService.removeMembership(users,mem);
    }


    //done

    @PostMapping("/checkmembership/{users}/{mem}")
    private Boolean check(@PathVariable long users,@PathVariable long mem){
        return  this.userService.checkMembership(users,mem);
    }


//    done
    @GetMapping("/getprojectdetails/{users}/{projects}")
    private Projects getproject(@PathVariable long users, @PathVariable long projects){
        return  this.userService.getProject(users,projects);
    }


    //done
    @GetMapping("/getallprojects/{users}")
    private List<Projects> getallpr(@PathVariable long users){
        return  this.userService.getallprojects(users);
    }


    //done
    @GetMapping("/getactiveprojects/{users}")
    private List<Projects> getactivepr(@PathVariable long users){
        return  this.userService.getactiveprojects(users);
    }


    //done
    @GetMapping("/getcancelledprojects/{users}")
    private List<Projects> getc(@PathVariable long users){
        return  this.userService.getcanceled(users);
    }

    @GetMapping("/findbyusername/{id}")
    private Users username(@PathVariable String id){
        return  this.userService.findbyusername(id);
    }


    //done
    @GetMapping("/getcompletedprojects/{users}")
    private List<Projects> getcomplpr(@PathVariable long users){
        return  this.userService.getCompleted(users);
    }



    //done
    @PostMapping("/addproject/{users}/{pr}")
    private Projects addpr(@PathVariable long users,@PathVariable long pr){
        return  this.userService.addProject(users,pr);
    }


    //done
    @PostMapping("/updatepr")
    private Projects update(@RequestBody Projects projects){
        return  this.userService.updateProject(projects);
    }



//    done
    @PostMapping("/extend/{user}/{pr}/{days}")
    private Projects extend(@PathVariable long user,@PathVariable long pr,@PathVariable long days){
        return  this.userService.requestextend(user,pr,days);
    }


    //done
    @PostMapping("/removefromproject/{user}/{pr}")
    private Projects removefrompr(@PathVariable long user,@PathVariable long pr){
        return  this.userService.removeuser(user,pr);
    }



    //done
    @GetMapping("/balance/{user}")
    private float bal(@PathVariable long user){
        return  this.userService.readbalance(user);
    }



//    done
    @GetMapping("/gettxn/{user}")
    private List<WalletTxn> txns(@PathVariable long user){
        return  this.userService.read(user);
    }


}

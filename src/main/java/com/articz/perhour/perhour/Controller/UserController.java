package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.*;
import com.articz.perhour.perhour.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    public JwtService jwtService;
    @Autowired
    private UsersDao usersDao;


    @Autowired
    public AuthenticationManager authenticationManager;



    @PostMapping(path ="/auth")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {
//		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUid(), authRequest.getPassword()));
        Optional<Users> users= usersDao.findByUsername(authRequest.getUsername());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new UsernameNotFoundException("Invalid User");
        }

    }




    @PostMapping("/verifyusername/{id}")
    private  boolean verufiyusername(@PathVariable String id){return  this.userService.verifyusername(id);}



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
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


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/update")
    private Users update(@RequestBody Users users){
        return  this.userService.update(users);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")    //done
    @DeleteMapping("/delete/{id}")
    private Users delete(@PathVariable long id){
        return  this.userService.remove(id);
    }


    //done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/getuser/{id}")
    private Users getUsers(@PathVariable long id){
        return  this.userService.get(id);
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/getrefferals/{id}")
    private List<Users> getref(@PathVariable long id){
        return  this.userService.getreferrals(id);
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/gettop")
    private List<Users> top3(){
        List<Users> top3=userService.top3();
        return  top3;
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/gettop15")
    private List<Users> top15(){
        List<Users> top3=userService.top15();
        return  top3;
    }


    //done

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/getall")
    private List<Users> getUsers(){
        return  this.userService.getall();
    }


    //done


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/addmembership/{id}/{id2}")
    private Users addmembership(@PathVariable long id,@PathVariable long id2){
        return  this.userService.addMembership(id,id2);
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/searchfreelancer/{id}")
    private List<Users> search(@PathVariable String id){
        return  this.userService.freelancer(id);
    }



    //done

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/removemembership/{users}/{mem}")
    private Users remove(@PathVariable long users,@PathVariable long mem){
        return  this.userService.removeMembership(users,mem);
    }


    //done



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/checkmembership/{users}/{mem}")
    private Boolean check(@PathVariable long users,@PathVariable long mem){
        return  this.userService.checkMembership(users,mem);
    }


//    done

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/getprojectdetails/{users}/{projects}")
    private Projects getproject(@PathVariable long users, @PathVariable long projects){
        return  this.userService.getProject(users,projects);
    }


    //done

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
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

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/getcancelledprojects/{users}")
    private List<Projects> getc(@PathVariable long users){
        return  this.userService.getcanceled(users);
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/findbyusername/{id}")
    private Users username(@PathVariable String id){
        return  this.userService.findbyusername(id);
    }


    //done

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/getcompletedprojects/{users}")
    private List<Projects> getcomplpr(@PathVariable long users){
        return  this.userService.getCompleted(users);
    }



    //done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/addproject/{users}/{pr}")
    private Projects addpr(@PathVariable long users,@PathVariable long pr){
        return  this.userService.addProject(users,pr);
    }


    //done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/updatepr")
    private Projects update(@RequestBody Projects projects){
        return  this.userService.updateProject(projects);
    }



//    done
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/extend/{user}/{pr}/{days}")
    private Projects extend(@PathVariable long user,@PathVariable long pr,@PathVariable long days){
        return  this.userService.requestextend(user,pr,days);
    }


    //done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping("/removefromproject/{user}/{pr}")
    private Projects removefrompr(@PathVariable long user,@PathVariable long pr){
        return  this.userService.removeuser(user,pr);
    }



    //done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/balance/{user}")
    private float bal(@PathVariable long user){
        return  this.userService.readbalance(user);
    }



//    done
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/gettxn/{user}")
    private List<WalletTxn> txns(@PathVariable long user){
        return  this.userService.read(user);
    }


}

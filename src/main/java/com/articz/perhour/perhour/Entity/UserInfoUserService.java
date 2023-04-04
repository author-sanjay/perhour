package com.articz.perhour.perhour.Entity;



import com.articz.perhour.perhour.Config.UserInfoUserDetails;
import com.articz.perhour.perhour.Dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserService implements UserDetailsService {

    @Autowired
    private UsersDao usersDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user=usersDao.findByUsername(username);
        return user.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
//        return null;
    }
}
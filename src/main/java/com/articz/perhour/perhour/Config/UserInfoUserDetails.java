package com.articz.perhour.perhour.Config;

import com.articz.perhour.perhour.Entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {

    private  long uid;
    private  String password;

    private  String username;

    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(Users userInfo) {
        uid=userInfo.getId();
        password=userInfo.getPassword();
        username=userInfo.getUsername();
        authorities= Arrays.stream(userInfo.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
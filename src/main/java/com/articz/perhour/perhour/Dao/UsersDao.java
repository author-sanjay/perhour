package com.articz.perhour.perhour.Dao;

import com.articz.perhour.perhour.Entity.Users;
import org.apache.catalina.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UsersDao extends JpaRepository<Users,Long> {
    public Optional<Users> findByUsername(String username);
    public  Optional<Users> findByEmailAndPassword(String email, String password);

//    public Optional<Users> findbyReferrcode(String code);

    public Optional<Users> findByReferralcode(String refferalcode);
}

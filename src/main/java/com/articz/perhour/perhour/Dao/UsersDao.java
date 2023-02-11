package com.articz.perhour.perhour.Dao;

import com.articz.perhour.perhour.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users,Long> {
    public Users findByUsername(String username);
}

package com.articz.perhour.perhour.Dao;

import com.articz.perhour.perhour.Entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MembershipDao extends JpaRepository<Membership,Long> {
}

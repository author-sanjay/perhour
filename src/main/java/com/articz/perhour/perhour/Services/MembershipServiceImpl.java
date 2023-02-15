package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.MembershipDao;
import com.articz.perhour.perhour.Entity.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MembershipServiceImpl implements MembershipService{

    @Autowired
    public MembershipDao membershipDao;

    @Override
    public Membership add(Membership membership) {
        membershipDao.save(membership);
        return membership;
    }

    @Override
    public Membership update(Membership membership) {
        Optional<Membership> membership1=membershipDao.findById(membership.getId());
        if(membership1.isPresent()){
            Membership membership2=membership1.get();
            membership2=membership;
            membershipDao.save(membership2);
            return membership2;
        }

        return null;    }


    @Override
    public Membership delete(long id) {
        Optional<Membership> membership1=membershipDao.findById(id);
        if(membership1.isPresent()){
            membershipDao.deleteById(id);
            return membership1.get();
        }
        return null;
    }

    @Override
    public List<Membership> readall() {
        return membershipDao.findAll();
    }

    @Override
    public Membership read(long id) {
        Optional<Membership> membership1=membershipDao.findById(id);
        if(membership1.isPresent()){

            return membership1.get();
        }
        return null;
    }
}

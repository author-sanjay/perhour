package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.BidsDao;
import com.articz.perhour.perhour.Dao.ProjectsDao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.Bids;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidsService{

    @Autowired
    public UsersDao usersDao;

    @Autowired
    public ProjectsDao projectsDao;

    @Autowired
    public BidsDao bidsDao;

    @Override
    public Bids add(long id, Bids bid, long project) {
        Optional<Users > users=usersDao.findById(id);
        Optional<Projects> projects=projectsDao.findById(project);
        if(users.isPresent() && projects.isPresent()){
            Users users1=users.get();
            if(users1.getBidsleft()>0){
                Projects projects1=projects.get();
                bid.setProject(projects1);
                bid.setBiddate(LocalDate.now());
                bid.setBidby(users1);
                bidsDao.save(bid);
                List<Bids> bids=projects1.getBids();
                bids.add(bid);
                projects1.setBids(bids);
                projectsDao.save(projects1);
                users1.setBidsleft(users1.getBidsleft()-1);
                usersDao.save(users1);
                return bid;
            }else{
                return null;
            }

        }
        return null;
    }

    @Override
    public Bids update( Bids bid) {
        Optional<Bids > bids=bidsDao.findById(bid.getId());
        if(bids.isPresent() ){
           Bids bids1=bids.get();

           bids1.setPrice(bid.getPrice());
           bids1.setBiddescription(bid.getBiddescription());

           bidsDao.save(bids1);
           return bids1;

        }
        return null;
    }

    @Override
    public Bids delete(long id, long bid) {
        Optional<Bids> bids=bidsDao.findById(bid);
        Optional<Projects> projects=projectsDao.findById(id);
        if(projects.isPresent() && bids.isPresent()){
            List<Bids> bidss=projects.get().getBids();
            for(int i=0;i<bidss.size();i++){
                if(bidss.get(i).getId()==bid){
                    bidss.remove(i);
                }
            }
            projects.get().setBids(bidss);
            bidsDao.deleteById(bid);
            projectsDao.save(projects.get());
            return bids.get();
        }
        return null;
    }

    @Override
    public Bids readsingle(long id) {
        Optional<Bids> bids=bidsDao.findById(id);
        return bids.get();
    }

    @Override
    public List<Bids> readforproject(long project) {
        Optional<Projects> projects=projectsDao.findById(project);
        if(projects.isPresent()){
            return projects.get().getBids();
        }
        return null;
    }
}

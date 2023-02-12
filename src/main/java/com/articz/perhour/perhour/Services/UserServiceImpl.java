package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.MembershipDao;
import com.articz.perhour.perhour.Dao.ProjectsDao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public MembershipDao membershipDao;

    @Autowired
    public ProjectsDao projectsDao;

    @Autowired
    public UsersDao usersDao;
    @Override
    public Users add(Users users) {
        Wallet wal=new Wallet();
        users.setWallet(wal);
        usersDao.save(users);
        return users;


    }

    @Override
    public Users update(Users users) {
        Optional<Users> users1=usersDao.findById(users.getId());
        if(users1.isPresent()){
            Users users2=users1.get();
            users2=users;
            usersDao.save(users2);
            return users2;
        }
        return null;
    }

    @Override
    public Users remove(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            usersDao.deleteById(users.get().getId());
            return  users.get();
        }
        return null;
    }

    @Override
    public Users get(long id) {
        Optional<Users> users= usersDao.findById(id);
        if(users.isPresent()){
            return users.get();
        }
        return null;
    }

    @Override
    public List<Users> getall() {

        return usersDao.findAll();
    }

    @Override
    public Users addMembership(long id, long membership)
    {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Users users1=users.get();
            Optional<Membership> membership1=membershipDao.findById(membership);
            if(membership1.isPresent()){
                users1.setMembership(membership1.get());
            }
            usersDao.save(users1);
            return users1;
        }

        return  null;
    }

    @Override
    public Users removeMembership(long id, long membership) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Users users1=users.get();
            users1.setMembership(null);
            usersDao.save(users1);
            return users1;
        }

        return null;
    }

    @Override
    public Users checkMembership(long id,long membership) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Optional<Membership> membership1=membershipDao.findById(membership);
            if(membership1.isPresent()){
                Users users1=users.get();
                LocalDate now = LocalDate.now();
                if(users1.getMembershipexpiry().isBefore(now.plusDays(membership1.get().getDuration()))){
                    users1.setMembership(null);
                }
            }

        }
        return null;
    }

    @Override
    public Projects getProject(long id, long project) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            List<Projects> projects = users.get().getProjects();
            for(int i=0;i<projects.size();i++){
                if(projects.get(i).getId()==project){
                    return projects.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public List<Projects> getallprojects(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            return users.get().getProjects();
        }
        return null;
    }

    @Override
    public List<Projects> getactiveprojects(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            List<Projects> active = null;
            List<Projects> projects=users.get().getProjects();
            for(int i=0;i<projects.size();i++){
                if(projects.get(i).getStatus()=="ACTIVE"){
                    active.add(projects.get(i));
                }
            }
            return active;
        }
        return null;
    }

    @Override
    public List<Projects> getCompleted(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            List<Projects> active = null;
            List<Projects> projects=users.get().getProjects();
            for(int i=0;i<projects.size();i++){
                if(projects.get(i).getStatus()=="COMPLETE"){
                    active.add(projects.get(i));
                }
            }
            return active;
        }

        return null;
    }

    @Override
    public List<Projects> getcanceled(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            List<Projects> active = null;
            List<Projects> projects=users.get().getProjects();
            for(int i=0;i<projects.size();i++){
                if(projects.get(i).getStatus()=="CANCELLED"){
                    active.add(projects.get(i));
                }
            }
            return active;
        }
        return null;

    }

    @Override
    public Projects addProject(long id, long project) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Optional<Projects> projects=projectsDao.findById(project);
            if(projects.isPresent()){
                List<Projects> userproject=users.get().getProjects();
                Projects projects1=projects.get();
                projects1.setStatus("STARTED");
                userproject.add(projects1);
                users.get().setProjects(null);
                users.get().setProjects(userproject);
                usersDao.save(users.get());
                projects1.setGivento(users.get());

            }
        }
        return null;
    }

    @Override
    public Projects updateProject(Projects project) {
        return null;
    }

    @Override
    public Projects updateProjectfreelancer(long id, Projects project) {
        return null;
    }

    @Override
    public Projects requestextend(long id, long project, long days) {
        return null;
    }

    @Override
    public Projects removeuser(long id, long project) {
        return null;
    }


    @Override
    public float readbalance(long id) {
        return 0;
    }

    @Override
    public WalletTxn add(long id, WalletTxn walletTxn) {
        return null;
    }

    @Override
    public List<WalletTxn> read(long id) {
        return null;
    }
}

package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.MembershipDao;
import com.articz.perhour.perhour.Dao.ProjectsDao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Dao.WalletDao;
import com.articz.perhour.perhour.Entity.*;
import com.razorpay.Order;
import org.aspectj.weaver.ast.Or;
import org.hibernate.query.spi.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 6;
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }


    @Autowired
    private EmailService emailService;

    @Autowired
    public RazorPay razorPay;

    @Autowired
    public MembershipDao membershipDao;

    @Autowired
    public ProjectsDao projectsDao;

    @Autowired
    public UsersDao usersDao;
    @Autowired
    private WalletDao walletDao;

    @Override
    public boolean verifyusername(String username) {
        Optional<Users> user=usersDao.findByUsername(username);
        if(user.isPresent()){
            return false;
        }
        else{
            return  true;
        }
    }

    @Override
    public Users add(Users users) {
        users.setBidsleft(10);
        Wallet wal=new Wallet();
        users.setWallet(wal);
        users.setPriority(5);
        users.setRole("ROLE_USER");
        Users users1=usersDao.save(users);
        Optional<Users> refferdby=usersDao.findByReferralcode(users.getReferredbycode());
        if(refferdby.isPresent()){
            users1.setReferedby(refferdby.get());
            users1.setReferralcode(generateRandomString().toUpperCase());
            usersDao.save(users1);
            usersDao.save(refferdby.get());
        }
//        emailService.sendSimpleEmail(users.getEmail(),"User Added Successfull","Thank You for signing up.");
        wal.setUser(users1);
        wal.setBalance(0);
        walletDao.save(wal);
        
        return users;
    }

    @Override
    public Users findbyusername(String username) {
        List<Users> us=usersDao.findAll();
        for(int i=0;i< us.size();i++){
            if(us.get(i).getUsername().equals(username)){
                return us.get(i);
            }
        }

        return  null;
    }

    @Override
    public Users login(String email, String password) {
        Optional<Users> user=usersDao.findByEmailAndPassword(email, password);
        if(user.isPresent()){
            return  user.get();
        }
        return null;
    }

    @Override
    public Users resetpassword(long id, String password) {
        Optional<Users> user=usersDao.findById(id);
        if (user.isPresent()){
            user.get().setPassword(password);
            usersDao.save(user.get());
            return user.get();
        }
        return null;
    }

    @Override
    public List<Users> getreferrals(long id) {
        List<Users> users=usersDao.findAll();
        ArrayList<Users> ans=new ArrayList<>();
        for(int i=0;i<users.size();i++){
            try{
            if(users.get(i).getReferedby().getId()==id){
                ans.add(users.get(i));
            }
            }catch (Exception e){
                continue;
            }
        }
        return ans;
    }

    @Override
    public List<Users> freelancer(String id) {
        List<Users> users=usersDao.findAll();
        ArrayList<Users> users1=new ArrayList<>();
        for(int i=0;i<users.size();i++){
            int index=users.get(i).getHeadline().indexOf(id);
            int idex2=users.get(i).getUsername().indexOf(id);
            int index3=users.get(i).getFirstname().indexOf(id);
            int index4=users.get(i).getAbout().indexOf(id);
            if(index!=-1 || idex2!=-1 ||index3!=-1 ||index4!=-1){
                users1.add(users.get(i));
            }
        }
        return users1;
    }


    @Override
    public Users update(Users users) {
        Optional<Users> users1=usersDao.findById(users.getId());
        if(users1.isPresent()){
            Users users2=users1.get();
            if(users.getPhone()!=null){
                users2.setPhone(users.getPhone());
            }
            if(users.getAddress()!=null){
                users2.setAddress(users.getAddress());
            }
            if(users.getWithdrawltype()!=null){
                users2.setWithdrawltype(users.getWithdrawltype());
            }
            if(users.getAccountnumber()!=null){
                users2.setAccountnumber(users.getAccountnumber());
            }
            if(users.getBankingname()!=null){
                users2.setBankingname(users.getBankingname());
            }
            if(users.getPhoto()!=null){
                users2.setPhoto(users.getPhoto());
            }

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
    public List<Users> top3() {
        List<Users> users= usersDao.findAll(Sort.by("priority"));
        ArrayList<Users> ans=new ArrayList<>();
        for(int i=users.size()-1;i>=0;i--){
            ans.add(users.get(i));
            if(ans.size()==3){
                break;
            }
        }

        return  ans;
    }

    @Override
    public List<Users> top15() {
        List<Users> users= usersDao.findAll(Sort.by("priority"));
        ArrayList<Users> ans=new ArrayList<>();
        for(int i=users.size()-4;i>=0;i--){
            ans.add(users.get(i));
            if(ans.size()==15){
                break;
            }
        }

        return  ans;
    }

    @Override
    public Users addMembership(long id, long membership)
    {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Users users1=users.get();
            Optional<Membership> membership1=membershipDao.findById(membership);
            if(membership1.isPresent()){


                    users1.setMembershipid(membership1.get().getId());
                    users1.setIsmember(true);
                    users1.setMembership(membership1.get());
                    users1.setBidsleft(users1.getBidsleft()+membership1.get().getExtendedbids());
                    if(membership1.get().getId()==6 || membership1.get().getId()==7){
                        users1.setPriority(users1.getPriority()+1);

                    }else if(membership1.get().getId()==5 || membership1.get().getId()==8){
                        users1.setPriority(users1.getPriority()+3);
                    }else{
                        users1.setPriority(users1.getPriority()+5);
                    }
                    if(users1.getMembershipexpiry()!=null){
                        users1.setMembershipexpiry(users1.getMembershipexpiry().plusDays(membership1.get().getDuration()));}
                    else {
                        users1.setMembershipexpiry(LocalDate.now().plusDays(membership1.get().getDuration()));
                    }

                usersDao.save(users1);
                return users1;
                }
                else {
                    return null;
                }


        }

        return  null;
    }

    @Override
    public Users removeMembership(long id, long membership) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Optional<Membership> membership1=membershipDao.findById(membership);
            if(membership1.isPresent()) {
                Users users1 = users.get();
                users1.setIsmember(false);
                users1.setMembershipid(0);
                users1.setMembership(null);
                users1.setMembershipexpiry(LocalDate.now());
                usersDao.save(users1);
                List<Users> users2= membership1.get().getUsers();
                for(int i=0;i<users2.size();i++){
                    if(users2.get(i).getId()==id){
                        users2.remove(i);
                    }
                }
                membership1.get().setUsers(users2);
                membershipDao.save(membership1.get());

                return users1;
            }
        }

        return null;
    }

    @Override
    public Boolean checkMembership(long id,long membership) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            Optional<Membership> membership1=membershipDao.findById(membership);
            if(membership1.isPresent()){
                Users users1=users.get();
                LocalDate now = LocalDate.now();
                if(users1.getMembershipexpiry().isBefore(now.plusDays(membership1.get().getDuration()))){
                    users1.setMembership(null);
                    usersDao.save(users1);
                    return false;
                }
                return  true;

            }

            return true;
        }
        return false;
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
            ArrayList<Projects> active=new ArrayList<>();
            List<Projects> projects=users.get().getProjects();
            for(int i=0;i<projects.size();i++){
                if(projects.get(i).getStatus().equals("STARTED")){
                    active.add(projects.get(i));
                    System.out.println("Yes");
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
            ArrayList<Projects> active = new ArrayList<>();
            List<Projects> projects=users.get().getProjects();
            for(int i=0;i<projects.size();i++){
                if(projects.get(i).getStatus().equals("Completed")){
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
            ArrayList<Projects> active = new ArrayList<>();
            List<Projects> projects=users.get().getProjects();
            for(int i=0;i<projects.size();i++){
                if(projects.get(i).getStatus().equals("CANCELLED")){
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
//                users.get().setProjects(null);
                users.get().setProjects(userproject);
                usersDao.save(users.get());
                projects1.setGivento(users.get());
                projects1.setStatus("STARTED");
                projectsDao.save(projects1);
                return  projects1;
            }
        }
        return null;
    }

    @Override
    public Projects updateProject(Projects project) {
        Optional<Projects> projects=projectsDao.findById(project.getId());
        if(projects.isPresent()){
            Projects projects1=projects.get();
            projects1=project;
            projectsDao.save(projects1);
            return projects1;
        }
        return null;
    }



    @Override
    public Projects requestextend(long id, long project, long days) {
        Optional<Projects> projects=projectsDao.findById(project);
        if(projects.isPresent()){
            Projects projects1=projects.get();
            projects1.setExtend(days);
            projectsDao.save(projects1);
            return projects1;
        }
        return null;
    }

    @Override
    public Projects removeuser(long id, long project) {
        Optional<Projects> projects=projectsDao.findById(project);
        if(projects.isPresent()){
            Projects projects1=projects.get();
            Optional<Users> users=usersDao.findById(id);
            if(users.isPresent()){
//                projects1.setGivento(null);
                projects1.setStatus("CANCELLED");
                Projects projects2=new Projects();
                projects2=projects1;
                projects2.setExtend(0);
                projects2.setStatus("ACTIVE");
                projects2.setBids(projects1.getBids());
                projects2.setGivento(null);
                projectsDao.save(projects2);
                projectsDao.save(projects1);
                return  projects1;
            }
        }
        return null;
    }


    @Override
    public float readbalance(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            return  users.get().getWallet().getBalance();
        }
        return 0;
    }

    @Override
    public List<WalletTxn> read(long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            return  users.get().getWallet().getTxn();
        }
        return null;
    }
}

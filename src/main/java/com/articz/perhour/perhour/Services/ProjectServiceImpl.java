package com.articz.perhour.perhour.Services;
import com.articz.perhour.perhour.Dao.ProjectsDao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Dao.WalletDao;
import com.articz.perhour.perhour.Dao.WalletTxnDao;
import com.articz.perhour.perhour.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService{

//    RazorpayClient instance= new RazorpayClient("rzp_test_UdfAt8GHS33FEO","5B3PKHfKokclOrhcpCuIzc0y");

    @Autowired
    public ProjectsDao projectsDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private WalletDao walletDao;
    @Autowired
    private WalletTxnDao walletTxnDao;

    @Autowired
    private  WalletTxnService walletTxnService;

    @Autowired
    private RazorPay razorPay;

    @Override
    public List<Projects> posted(long id) {
        List<Projects> all=projectsDao.findAll();
        if(all.size()>0){
            ArrayList<Projects> ans=new ArrayList<>();
            for(int i=0;i<all.size();i++){
                if(all.get(i).getGivenby().getId()==id){
                    ans.add(all.get(i));
                }
            }

            return ans;
        }
        return null;
    }

    @Override
    public List<Projects> assigned(long id) {
        List<Projects> all =projectsDao.findAll();
        if(all.size()>0){
            ArrayList<Projects> ans=new ArrayList<>();
            for(int i=0;i<all.size();i++){
                if(all.get(i).getGivento()!=null){
                if(all.get(i).getGivento().getId()==id){
                    ans.add(all.get(i));
                }
                }else{
                    continue;
                }
            }

            return ans;
        }
        return null;
    }

    @Override
    public Projects add(Projects project,long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            ArrayList<String> tagss=new ArrayList<>();
            if(project.getTaggs()!=null){
            String st[]=project.getTaggs().split(",");
            for(String sr:st){
                tagss.add(sr);

            }
            }
            project.setActive(true);
            project.setStatus("Placed");
            project.setPostedon(LocalDate.now());
            project.setTags(tagss);
            project.setGivenby(users.get());
            project.setGivenbyy(users.get().getFirstname()+" "+users.get().getLastname());

            projectsDao.save(project);
            return project;
        }
        return null;
    }

    @Override
    public Projects submit(long id, Projects prr) {
        Optional<Projects> pr=projectsDao.findById(id);
        if(pr.isPresent()){
            pr.get().setDeliverylink(prr.getDeliverylink());
            pr.get().setStatus("Delivered");
            projectsDao.save(pr.get());
            return  pr.get();
        }
        return null;
    }

    @Override
    public Projects update(Projects project) {
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
    public Projects delete(long project) {
        Optional<Projects> projects=projectsDao.findById(project);
        if(projects.isPresent()){

            try {
                Users user = projects.get().getGivento();
                List<Projects> projects1 = user.getProjects();
                for (int i = 0; i < projects1.size(); i++) {
                    if (projects1.get(i).getId() == project) {
                        projects1.remove(i);
                    }
                }

                Users user2 = projects.get().getGivenby();
                List<Projects> projects2 = user2.getProjects();
                for (int i = 0; i < projects2.size(); i++) {
                    if (projects2.get(i).getId() == project) {
                        projects2.remove(i);
                    }
                }


                projectsDao.deleteById(project);

                return projects.get();
            }
            catch (Exception e){
                projectsDao.deleteById(project);
            }
        }
        return null;
    }

    @Override
    public List<Projects> getall() {
        return projectsDao.findAll();
    }

    @Override
    public Projects getsingle(long id) {
        Optional<Projects> projects1= projectsDao.findById(id);
        if(projects1.isPresent()){
            return projects1.get();
        }
        return  null;
    }

    @Override
    public Projects makepayment(long project) {
        Optional<Projects> projects=projectsDao.findById(project);
        if(projects.isPresent()){
            /* TODO MAKE PAYMENT */

        }
        return null;
    }

    @Override
    public List<Projects> bytags(String st) {
        List<Projects> pr=projectsDao.findAll();
        ArrayList<Projects> ans=new ArrayList<>();
        for(int i=0;i<pr.size();i++){
            List<String> tagss=pr.get(i).getTags();
            for(String tg:tagss){
                if(tg.equals(st)){
                    ans.add(pr.get(i));
                }
            }
        }
        return ans;
    }

    @Override
    public List<Projects> getlatest() {
        List<Projects> projects=projectsDao.findAll();
        ArrayList<Projects> ans=new ArrayList<>();
        for(int i=0;i<projects.size();i++){
            if((projects.get(i).getPostedon().equals(LocalDate.now())) || (projects.get(i).getPostedon().equals(LocalDate.now().minusDays(1)))){
                ans.add(projects.get(i));
            }
        }
        return ans;
    }

    @Override
    public Projects assignproject(long userid, long projectid) {
        Optional<Users> user=usersDao.findById(userid);
        Optional<Projects> pr=projectsDao.findById(projectid);
        if(user.isPresent() && pr.isPresent()){
            if(pr.get().getGivento()!=null && pr.get().getGivenby().getId()==userid){
                return null;
            }
            else
            {
            pr.get().setGivento(user.get());
            pr.get().setStatus("Assigned");
            pr.get().setPaymentdone(true);
            pr.get().setGiventoo(user.get().getId());
            pr.get().setDeliverydate(LocalDate.now().plusDays( Long.parseLong(pr.get().getTimelimit())  ));
            pr.get().setLastdate(LocalDate.now().plusDays( Long.parseLong(pr.get().getTimelimit())  ));
            List<Bids> bids=pr.get().getBids();
            Bids bid=new Bids();
            for(int i=0;i<bids.size();i++){
                if(bids.get(i).getBidby().getId()==userid){
                    bid=bids.get(i);
                }
            }
            pr.get().setDeliverydate(LocalDate.now().plusDays(bid.getProposedtime()));
            pr.get().setLastdate(LocalDate.now().plusDays(bid.getProposedtime()));
            pr.get().setGiventoo(user.get().getId());
            pr.get().setGiventoname(user.get().getUsername());
            pr.get().setAssignedtoid(user.get().getId());
           Projects pr2= projectsDao.save(pr.get());
            List<Projects> projects=user.get().getProjects();
            projects.add(pr2);
            user.get().setProjects(projects);
            usersDao.save(user.get());
            return pr2;
            }
        }
        return null;
    }

    @Override
    public Projects requestreview(long projectid) {
        Optional<Projects> pr=projectsDao.findById(projectid);
        if(pr.isPresent()){
            pr.get().setStatus("Requires Review");
            projectsDao.save(pr.get());
            return  pr.get();
        }
        return null;
    }

    @Override
    public List<Projects> searchresults(String str) {
        List<Projects> pr=projectsDao.findAll();
        ArrayList<Projects> ans=new ArrayList<>();
        for(int i=0;i<pr.size();i++){
            int title=pr.get(i).getTitle().indexOf(str);
            int desc=pr.get(i).getFulldescription().indexOf(str);

            if(title!=-1||desc!=-1){
                if (pr.get(i).getPostedon().isAfter(LocalDate.now().minusDays(3))){
                    ans.add(pr.get(i));
                }
            }
        }
        return ans;
    }

    @Override
    public Projects revoke(long id) {
        Optional<Projects> pr=projectsDao.findById(id);
        if(pr.isPresent()){
            pr.get().setStatus("Cancelled");
            projectsDao.save(pr.get());
            return pr.get();
        }
        return null;
    }

    @Override
    public Projects feedback(long id, Projects projects) {
        Optional<Projects> pr=projectsDao.findById(id);
        if(pr.isPresent()){
            pr.get().setFeedback(projects.getFeedback());
            pr.get().setFeedbackstars(projects.getFeedbackstars());
            projectsDao.save(pr.get());
            Users ur=pr.get().getGivento();
            ur.setTotalstars(ur.getTotalstars()+projects.getFeedbackstars());
            List<Projects> prr=ur.getProjects();
            long count=0;
            for(int i=0;i<prr.size();i++){
                if(prr.get(i).getStatus().equals("Completed")){
                    count++;
                }
            }
            ur.setStar(ur.getTotalstars()/count);
//            ur.setStar((ur.getStar()+projects.getFeedbackstars())/proj);
            usersDao.save(ur);
            return  pr.get();
        }
        return null;
    }

    @Override
    public Projects complete(long id) {
        Optional< Projects> pr=projectsDao.findById(id);
        if(pr.isPresent()){
            pr.get().setStatus("Completed");
            projectsDao.save(pr.get());
            Users user=pr.get().getGivento();
            user.setPriority(user.getPriority()+1);
            user.setReferralcontri(user.getReferralcontri()+pr.get().getPrice()*0.05);
            usersDao.save(user);
            WalletTxn txn=new WalletTxn();
            txn.setDate(LocalDate.now());
            txn.setProjectid(id);
            txn.setProjecttitle(pr.get().getTitle());
            txn.setIncoming(true);
            txn.setWallet(pr.get().getGivento().getWallet());
            txn.setAmount((float) (pr.get().getPrice()*0.9));
            walletTxnService.add(txn,pr.get().getGivento().getId());
            return pr.get();

        }
        return null;
    }

    @Override
    public List<Projects> bycategory(String category) {
        List<Projects> pr= projectsDao.findByCategory(category);
        ArrayList<Projects> ar=new ArrayList<>();
        for (int i=0;i<pr.size();i++){
            if(pr.get(i).getPostedon().isAfter(LocalDate.now().minusDays(3))){
                if(pr.get(i).getStatus().equals("Placed")){
                    ar.add(pr.get(i));
                }
            }
        }

        return ar;
    }


}

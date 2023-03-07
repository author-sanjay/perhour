package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.ProjectsDao;
import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    public ProjectsDao projectsDao;
    @Autowired
    private UsersDao usersDao;

    @Override
    public Projects add(Projects project,long id) {
        Optional<Users> users=usersDao.findById(id);
        if(users.isPresent()){
            ArrayList<String> tagss=new ArrayList<>();
            String st[]=project.getTaggs().split(",");
            for(String sr:st){
                tagss.add(sr);

            }
            project.setPostedon(LocalDate.now());
            project.setTags(tagss);
            project.setGivenby(users.get());
            projectsDao.save(project);
            return project;
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
}

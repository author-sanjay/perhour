package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.ProjectsDao;
import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    public ProjectsDao projectsDao;

    @Override
    public Projects add(Projects project) {
        return projectsDao.save(project);
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
            Users user=projects.get().getGivento();
            List<Projects> projects1=user.getProjects();
            for(int i=0;i<projects1.size();i++){
                if(projects1.get(i).getId()==project){
                    projects1.remove(i);
                }
            }

            Users user2=projects.get().getGivenby();
            List<Projects> projects2=user2.getProjects();
            for(int i=0;i<projects2.size();i++){
                if(projects2.get(i).getId()==project){
                    projects2.remove(i);
                }
            }


            projectsDao.deleteById(project);

            return projects.get();
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
}

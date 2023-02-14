package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.ProjectsDao;
import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Entity.Projects;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
            projectsDao.deleteById(project);
            return projects.get();
        }
        return null;
    }

    @Override
    public Projects makepayment(long project) {
        Optional<Projects> projects=projectsDao.findById(project);
        if(projects.isPresent()){
//            projectsDao.deleteById(project);
//            return projects.get();
        }
        return null;
    }
}

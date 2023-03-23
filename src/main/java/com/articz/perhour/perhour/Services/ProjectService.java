package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Entity.Projects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    public List<Projects> posted(long id);
    public  List<Projects> assigned(long id);
    public Projects add(Projects project,long id) ;

    public Projects submit(long id, Projects pr);

    public Projects update(Projects project) ;

    public Projects delete(long project) ;

    public List<Projects> getall();

    public  Projects getsingle(long id);

    public Projects makepayment(long project);

    public List<Projects> bytags(String st);

    public List<Projects> getlatest();

    public Projects assignproject(long userid, long projectid);


    public Projects requestreview(long projectid);

   public Projects revoke(long id);

   public  Projects feedback(long id,Projects projects);

   public  Projects complete(long id);

   public List<Projects> bycategory(String category);
}

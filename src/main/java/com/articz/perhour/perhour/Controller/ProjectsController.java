package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Services.ProjectService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectService projectService;



    @PostMapping(path = "/add/{id}")
    public Projects add(@RequestBody Projects projects,@PathVariable long id){
        return  this.projectService.add(projects, id);
    }

    @PostMapping(path = "/getposted/{id}")
    public List<Projects> posted(@PathVariable long id){
        return  this.projectService.posted(id);
    }

    @PostMapping(path = "/assigned/{id}")
    public List<Projects> assigned(@PathVariable long id){
        return  this.projectService.assigned(id);
    }



    @PostMapping(path = "/update")
    public Projects update(@RequestBody Projects projects){
        return  this.projectService.update(projects);
    }

    @GetMapping(path = "/getlatest")
    public  List<Projects> getlatest(){
        return  this.projectService.getlatest();
    }
    @DeleteMapping(path = "/delete/{id}")
    public Projects delete(@PathVariable long id){
        return  this.projectService.delete(id);
    }


    @GetMapping(path = "/getall")
    public List<Projects> getall(){
        return  this.projectService.getall();
    }


    @GetMapping(path = "/get/{id}")
    public Projects getsingle(@PathVariable long id){
        return  this.projectService.getsingle(id);
    }


    @GetMapping(path = "/getbycategory/{id}")
    public List<Projects> cat(@PathVariable String id){
        return  this.projectService.bycategory(id);
    }

    @PostMapping(path = "/makepayment/{id}")
    public Projects pay(@PathVariable long id){
        return  this.projectService.makepayment(id);
    }


    @PostMapping(path = "/submit/{id}")
    public Projects submit(@PathVariable long id,@RequestBody Projects pr){
        return this.projectService.submit(id,pr);

    }

    @PostMapping(path = "/assignproject/{id}/{id2}")
    public Projects assignproject(@PathVariable long id, @PathVariable long id2){
        return this.projectService.assignproject(id,id2);

    }

    @PostMapping(path = "/revoke/{id}")
    public Projects revoke(@PathVariable long id){
        return this.projectService.revoke(id);

    }

    @PostMapping(path = "/feedback/{id}")
    public Projects revoke(@PathVariable long id,@RequestBody Projects pr){
        return this.projectService.feedback(id,pr);

    }

    @PostMapping(path = "/complete/{id}")
    public Projects compleye(@PathVariable long id){
        return this.projectService.complete(id);

    }



    @PostMapping(path = "/revview/{id}")
    public Projects review(@PathVariable long id){
        return this.projectService.requestreview(id);

    }


    @PostMapping(path = "/searched/{id}")
    public List<Projects> searched(@PathVariable String id){
        return this.projectService.searchresults(id);
    }




}

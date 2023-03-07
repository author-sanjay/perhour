package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/makepayment/{id}")
    public Projects pay(@PathVariable long id){
        return  this.projectService.makepayment(id);
    }

}

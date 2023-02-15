package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Membership;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectService projectService;



    @PostMapping(path = "/add")
    public Projects add(@RequestBody Projects projects){
        return  this.projectService.add(projects);
    }



    @PostMapping(path = "/update")
    public Projects update(@RequestBody Projects projects){
        return  this.projectService.update(projects);
    }
}

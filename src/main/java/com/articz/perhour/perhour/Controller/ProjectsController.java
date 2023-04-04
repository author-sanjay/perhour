package com.articz.perhour.perhour.Controller;
import com.articz.perhour.perhour.Entity.Projects;
import com.articz.perhour.perhour.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectService projectService;



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/add/{id}")
    public Projects add(@RequestBody Projects projects,@PathVariable long id){
        return  this.projectService.add(projects, id);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/getposted/{id}")
    public List<Projects> posted(@PathVariable long id){
        return  this.projectService.posted(id);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/assigned/{id}")
    public List<Projects> assigned(@PathVariable long id){
        return  this.projectService.assigned(id);
    }




    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/update")
    public Projects update(@RequestBody Projects projects){
        return  this.projectService.update(projects);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/getlatest")
    public  List<Projects> getlatest(){
        return  this.projectService.getlatest();
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @DeleteMapping(path = "/delete/{id}")
    public Projects delete(@PathVariable long id){
        return  this.projectService.delete(id);
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/getall")
    public List<Projects> getall(){
        return  this.projectService.getall();
    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/get/{id}")
    public Projects getsingle(@PathVariable long id){
        return  this.projectService.getsingle(id);
    }




    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "/getbycategory/{id}")
    public List<Projects> cat(@PathVariable String id){
        return  this.projectService.bycategory(id);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/makepayment/{id}")
    public Projects pay(@PathVariable long id){
        return  this.projectService.makepayment(id);
    }




    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/submit/{id}")
    public Projects submit(@PathVariable long id,@RequestBody Projects pr){
        return this.projectService.submit(id,pr);

    }




    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/assignproject/{id}/{id2}")
    public Projects assignproject(@PathVariable long id, @PathVariable long id2){
        return this.projectService.assignproject(id,id2);

    }



    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/revoke/{id}")
    public Projects revoke(@PathVariable long id){
        return this.projectService.revoke(id);

    }




    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/feedback/{id}")
    public Projects revoke(@PathVariable long id,@RequestBody Projects pr){
        return this.projectService.feedback(id,pr);

    }





    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/complete/{id}")
    public Projects compleye(@PathVariable long id){
        return this.projectService.complete(id);

    }





    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/revview/{id}")
    public Projects review(@PathVariable long id){
        return this.projectService.requestreview(id);

    }





    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @PostMapping(path = "/searched/{id}")
    public List<Projects> searched(@PathVariable String id){
        return this.projectService.searchresults(id);
    }

}

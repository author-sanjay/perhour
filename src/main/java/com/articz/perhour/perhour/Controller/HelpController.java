package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.Helpandsupport;
import com.articz.perhour.perhour.Services.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/help")
public class HelpController {

    @Autowired
    public HelpService helpService;
    @PostMapping(path = "/add/{id}")
    public Helpandsupport add(@RequestBody Helpandsupport helpandsupport, @PathVariable long id){
        return this.helpService.add(helpandsupport, id);
    }


    @PostMapping(path = "/withdrawll/{id}/{id2}/{id3}/{id4}/{id5}")
    public Helpandsupport add(@RequestBody Helpandsupport helpService,  @PathVariable double id, @PathVariable String id2,@PathVariable String id3,@PathVariable String id4,@PathVariable long id5){
        return this.helpService.withdrawl(helpService,id,id2, id3,id4, id5);
    }

    @PostMapping(path = "/update")
    public Helpandsupport update(@RequestBody Helpandsupport helpandsupport){
        return this.helpService.update(helpandsupport);
    }

    @GetMapping(path = "/getsingle/{id}")
    public Helpandsupport getall(@PathVariable long id){
        return this.helpService.getsingle(id);
    }

    @GetMapping(path = "/getactive")
    public List<Helpandsupport> getactive(){
        return this.helpService.getactive();
    }


}

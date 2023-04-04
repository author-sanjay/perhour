package com.articz.perhour.perhour.Controller;

import com.articz.perhour.perhour.Entity.EmailReqBody;
import com.articz.perhour.perhour.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/send")
    private void send(@RequestBody EmailReqBody emailReqBody){
        this.emailService.sendSimpleEmail(emailReqBody);
    }




    @PostMapping("/forgotpassword/{id}")
    private void send(@PathVariable String id){
        this.emailService.forgotpassword(id);
    }
}

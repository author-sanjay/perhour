package com.articz.perhour.perhour.Services;

import com.articz.perhour.perhour.Dao.UsersDao;
import com.articz.perhour.perhour.Entity.EmailReqBody;
import com.articz.perhour.perhour.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmailService {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 10;
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    @Autowired
    private JavaMailSender javamailsender;
    @Autowired
    private UsersDao usersDao;


    public void sendSimpleEmail(EmailReqBody req){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(req.getToEmail());
        simpleMailMessage.setFrom("noreply@articz.tech");
        simpleMailMessage.setText(req.getBody());
        simpleMailMessage.setSubject(req.getSubject());
        try{
        javamailsender.send(simpleMailMessage);
        System.out.println("Sent!!!!!!!!");}
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void forgotpassword(String user){
        Optional<Users> users=usersDao.findByEmail(user);
        if(users.isPresent()){
            String newPassword=generateRandomString();
            System.out.println(newPassword);
            users.get().setPassword(newPassword);
            usersDao.save(users.get());
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setTo(users.get().getEmail());
            simpleMailMessage.setText("I see You need help in loggin into your account...\n  I have generated a new password for you to login to your account. \n \n Make sure that when you login in successfully the first thing you do is you change your password of your own choice.\nYour New Password is \n"+newPassword+" \n\nRegards\nSanjay Kumar\nCIO\nArticz");
            simpleMailMessage.setSubject("Did you forgot your password?\uD83D\uDE15");
            javamailsender.send(simpleMailMessage);
        }

    }
}

package com.Maker.controller;

import com.Maker.model.DAOUser;
import com.Maker.model.EmailDetails;
import com.Maker.service.EmailService;
import com.Maker.service.FireBaseTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Email")
public class EmailController {


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;



    public String  sendMail(DAOUser daoUser)
    {
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(daoUser.getEmail());
            mailMessage.setText("\nusername: " + daoUser.getUsername() + "\nPassword: 1234");
            mailMessage.setSubject("LoginInformation");

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }

    }
}

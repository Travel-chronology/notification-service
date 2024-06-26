package by.nexer.notificationservice.controller;

import by.nexer.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        emailService.sendSimpleEmail("nexer.help@gmail.com", "Test Subject", "Test email body");
        return "Email sent successfully!";
    }
}
package com.thalesbensi.email_service.controllers;

import com.thalesbensi.email_service.application.EmailSenderService;
import com.thalesbensi.email_service.core.domain.EmailRequest;
import com.thalesbensi.email_service.core.exceptions.EmailServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try {
            emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email sent Successfully");
        }
        catch (EmailServiceException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}

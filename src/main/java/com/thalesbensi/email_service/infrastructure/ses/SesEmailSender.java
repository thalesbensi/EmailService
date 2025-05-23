package com.thalesbensi.email_service.infrastructure.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.thalesbensi.email_service.adapters.EmailSenderAdapter;
import com.thalesbensi.email_service.core.exceptions.EmailServiceException;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderAdapter {

    private final AmazonSimpleEmailService amazonSimpleEmailService;
    private final String from;

    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
        String envFrom = System.getenv("MY_SOURCE_EMAIL");
        if (envFrom == null || envFrom.isEmpty()) {
            throw new IllegalStateException("Environment variable 'MY_SOURCE_EMAIL' is required");
        }
        this.from = envFrom;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(from)
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );
        try{
            amazonSimpleEmailService.sendEmail(request);
        }
        catch (AmazonSimpleEmailServiceException exception) {
            throw new EmailServiceException("Some Error Occurred While Sending Email:", exception);
        }
    }
}

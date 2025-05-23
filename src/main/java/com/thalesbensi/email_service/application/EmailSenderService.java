package com.thalesbensi.email_service.application;

import com.thalesbensi.email_service.adapters.EmailSenderAdapter;
import com.thalesbensi.email_service.core.usecases.EmailSenderUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderAdapter emailSenderAdapter;

    public EmailSenderService(EmailSenderAdapter emailSenderAdapter) {
        this.emailSenderAdapter = emailSenderAdapter;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        emailSenderAdapter.sendEmail(to, subject, body);
    }
}

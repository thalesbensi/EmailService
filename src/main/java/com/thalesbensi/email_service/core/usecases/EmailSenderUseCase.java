package com.thalesbensi.email_service.core.usecases;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body);
}

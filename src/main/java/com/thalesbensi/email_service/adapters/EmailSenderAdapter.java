package com.thalesbensi.email_service.adapters;

public interface EmailSenderAdapter {

    void sendEmail(String to, String subject, String body);
}

package com.thalesbensi.email_service.core.domain;

public record EmailRequest(String to, String subject, String body) {
}

package com.emil.portfolio.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);

    /**
     * UUID = Universal Unique ID (128 bits)
     * .randomUUID creates temporary ID
     */

    public UUID contactFormHaveBeenFilledAndSent(ContactForm form) {
        UUID id = UUID.randomUUID(); // Temporary before DB is implemented

        logger.info("contact trackingId={}, name={} {}, phonePresent={}, email={}, messageLen={}",
                id,
                nullSafe(form.getFirstName()),
                nullSafe(form.getLastName()),
                form.getPhoneNumber() != null && !form.getPhoneNumber().isBlank(),
                maskEmail(form.getEmail()),
                form.getMessage() != null ? form.getMessage().length() : 0
        );

        // ...Save to DB
        // ...Send email to form-filler through Brevo
        return id;
    }

    private String nullSafe(String string) { return string == null ? "" : string; }


    private String maskEmail(String email) {
        if (email == null) return "";
        int at = email.indexOf('@');
        if (at <= 1) return "***";
        String local = email.substring(0, at);
        String domain = email.substring(at);
        return local.charAt(0) + "***" + domain;
    }


}

package com.Maker.service;

import com.Maker.model.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
}

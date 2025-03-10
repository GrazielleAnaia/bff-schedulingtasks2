package com.grazielleanaia.bff_schedulingtasks2.business;


import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.TasksDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.infrastructure.client.EmailClient;
import org.springframework.stereotype.Service;

@Service


public class EmailService {

    private final EmailClient emailClient;


    public EmailService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void sendEmail(TasksDTOResponse tasksDTO) {
        emailClient.sendEmail(tasksDTO);
    }


}

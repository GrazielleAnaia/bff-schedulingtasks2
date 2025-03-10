package com.grazielleanaia.bff_schedulingtasks2.business;

import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.LoginDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.TasksDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.TasksDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.enums.NotificationStatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor

public class CronService {

    private final TasksService tasksService;
    private final EmailService emailService;
    private final CustomerService customerService;

    public CronService(TasksService tasksService, EmailService emailService, CustomerService customerService) {
        this.tasksService = tasksService;
        this.emailService = emailService;
        this.customerService = customerService;
    }

    @Value("${customer.email}")
    private String email;

    @Value("${customer.password}")
    private String password;

    @Scheduled(cron = "${cron.time}")


    public void SearchTasksNextHour() {
        String token = login(convertToRequestDTO());
        log.info("Started searching for tasks");
        LocalDateTime futureHour = LocalDateTime.now().plusHours(1);
        LocalDateTime futureHourPlusFive = LocalDateTime.now().plusHours(1).plusMinutes(5);
        List<TasksDTOResponse> tasksList = tasksService.searchTasksByPeriod(futureHour, futureHourPlusFive, token);
        log.info("Tasks found" + tasksList);

        tasksList.forEach(task -> {
                    emailService.sendEmail(task);
            log.info("Customer email sent" + task.getCustomerEmail());
                    tasksService.changeNotificationStatus(task.getId(),
                            NotificationStatusEnum.NOTIFIED,
                            token);
                }
        );

        log.info("Notification of tasks was succesfully finalized");
    }

    public String login(LoginDTORequest loginDTORequest) {
        return customerService.loginCustomer(loginDTORequest);
    }

    public LoginDTORequest convertToRequestDTO() {
        return LoginDTORequest.builder()
                .email(email)
                .password(password)
                .build();
    }

}

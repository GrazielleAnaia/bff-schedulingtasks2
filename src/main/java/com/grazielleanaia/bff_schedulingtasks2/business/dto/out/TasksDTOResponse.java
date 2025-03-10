package com.grazielleanaia.bff_schedulingtasks2.business.dto.out;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.grazielleanaia.bff_schedulingtasks2.business.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor



@Builder

public class TasksDTOResponse {

    private String id;

    private String customerEmail;

    private String taskName;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime eventDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime changeDate;

    private NotificationStatusEnum notificationStatusEnum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public NotificationStatusEnum getNotificationStatusEnum() {
        return notificationStatusEnum;
    }

    public void setNotificationStatusEnum(NotificationStatusEnum notificationStatusEnum) {
        this.notificationStatusEnum = notificationStatusEnum;
    }


    public TasksDTOResponse() {
    }

    public TasksDTOResponse(String id, String customerEmail, String taskName, String description, LocalDateTime creationDate, LocalDateTime eventDate, LocalDateTime changeDate, NotificationStatusEnum notificationStatusEnum) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.taskName = taskName;
        this.description = description;
        this.creationDate = creationDate;
        this.eventDate = eventDate;
        this.changeDate = changeDate;
        this.notificationStatusEnum = notificationStatusEnum;
    }
}

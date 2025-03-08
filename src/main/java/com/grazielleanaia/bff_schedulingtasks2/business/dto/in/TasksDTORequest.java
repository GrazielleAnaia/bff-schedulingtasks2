package com.grazielleanaia.bff_schedulingtasks2.business.dto.in;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.grazielleanaia.bff_schedulingtasks2.business.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



@Builder

public class TasksDTORequest {

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
}

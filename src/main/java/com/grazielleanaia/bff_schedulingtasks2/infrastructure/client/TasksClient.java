package com.grazielleanaia.bff_schedulingtasks2.infrastructure.client;


import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.TasksDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.TasksDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.enums.NotificationStatusEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "tasks", url = "${tasks.url}")
public interface TasksClient {


    @PostMapping
    TasksDTOResponse createTask(@RequestBody TasksDTORequest tasksDTO,
                                @RequestHeader("Authorization") String token);

    @GetMapping
    List<TasksDTOResponse> searchTasksByEmail(@RequestHeader("Authorization") String token);

    @GetMapping("/events")
    List<TasksDTOResponse> searchTasksByPeriod(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                       LocalDateTime initialDate,
                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                       LocalDateTime finalDate,
                                              @RequestHeader("Authorization") String token);

    @DeleteMapping
    void deleteTaskById(@RequestParam("id") String id,
                        @RequestHeader("Authorization") String token);

    @PutMapping
    TasksDTOResponse updateTasks(@RequestBody TasksDTORequest tasksDTO,
                                @RequestParam("id") String id,
                                @RequestHeader("Authorization") String token);

    @PatchMapping
    TasksDTOResponse changeNotificationStatus(@RequestParam("id") String id,
                                             @RequestParam("status") NotificationStatusEnum status,
                                             @RequestHeader("Authorization") String token);

}

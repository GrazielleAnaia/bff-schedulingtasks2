package com.grazielleanaia.bff_schedulingtasks2.controller;


import com.grazielleanaia.bff_schedulingtasks2.business.TasksService;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.TasksDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.TasksDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.enums.NotificationStatusEnum;
import com.grazielleanaia.bff_schedulingtasks2.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
//@RequiredArgsConstructor
@Tag(name = "Tasks", description = "Create customer tasks")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)

public class TasksController {

    public final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    @Operation(summary = "Save customer task", description = "Create a new task")
    @ApiResponse(responseCode = "200", description = "Task successfully saved")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<TasksDTOResponse> createTask(@RequestBody TasksDTORequest tasksDTO,
                                                       @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tasksService.createTask(token, tasksDTO));
    }

    @GetMapping
    @Operation(summary = "Search customer task list by email", description = "Search customer task by email")
    @ApiResponse(responseCode = "200", description = "Task successfully found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "403", description = "Email not found")
    @ApiResponse(responseCode = "401", description = "Customer not authorized")
    public ResponseEntity<List<TasksDTOResponse>> searchTasksByEmail(@RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tasksService.searchTasksByEmail(token));
    }

    @GetMapping("/events")
    @Operation(summary = "Search customer task by period", description = "Search customer task by period")
    @ApiResponse(responseCode = "200", description = "Task successfully found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "403", description = "Email not found")
    @ApiResponse(responseCode = "401", description = "Customer not authorized")
    public ResponseEntity<List<TasksDTOResponse>> searchTasksByPeriod(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                              LocalDateTime initialDate,
                                                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                              LocalDateTime finalDate,
                                                                     @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tasksService.searchTasksByPeriod(initialDate, finalDate, token));
    }

    @DeleteMapping
    @Operation(summary = "Delete tasks by id", description = "Delete tasks by id")
    @ApiResponse(responseCode = "200", description = "Task successfully deleted")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "403", description = "Task id not found")
    @ApiResponse(responseCode = "401", description = "Customer not authorized")
    public ResponseEntity<Void> deleteTaskById(@RequestParam("id") String id,
                                               @RequestHeader(value = "Authorization", required = false) String token) {
        tasksService.deleteTaskById(id, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Update tasks", description = "Tasks updated")
    @ApiResponse(responseCode = "200", description = "Task successfully updated")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "403", description = "Task id not found")
    @ApiResponse(responseCode = "401", description = "Customer not authorized")
    public ResponseEntity<TasksDTOResponse> updateTasks(@RequestBody TasksDTORequest tasksDTO,
                                                       @RequestParam("id") String id,
                                                       @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tasksService.updateTasks(tasksDTO, id, token));

    }

    @PatchMapping
    @Operation(summary = "Change task status", description = "Task status changed")
    @ApiResponse(responseCode = "200", description = "Task status successfully changed")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "403", description = "Task id not found")
    @ApiResponse(responseCode = "401", description = "Customer not authorized")
    public ResponseEntity<TasksDTOResponse> changeNotificationStatus(@RequestParam("id") String id,
                                                                    @RequestParam("status") NotificationStatusEnum status,
                                                                    @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tasksService.changeNotificationStatus(id, status, token));
    }


}

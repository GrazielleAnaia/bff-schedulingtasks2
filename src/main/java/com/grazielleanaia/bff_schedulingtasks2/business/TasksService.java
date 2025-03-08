package com.grazielleanaia.bff_schedulingtasks2.business;


import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.TasksDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.TasksDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.enums.NotificationStatusEnum;
import com.grazielleanaia.bff_schedulingtasks2.infrastructure.client.TasksClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

//@RequiredArgsConstructor
public class TasksService {

    private final TasksClient tasksClient;

    public TasksService(TasksClient tasksClient) {
        this.tasksClient = tasksClient;
    }

    public TasksDTOResponse createTask(String token, TasksDTORequest tasksDTO) {
        return tasksClient.createTask(tasksDTO, token);
    }

    public void deleteTaskById(String id, String token) {
        tasksClient.deleteTaskById(id, token);
    }

    public List<TasksDTOResponse> searchTasksByEmail(String token) {
        return tasksClient.searchTasksByEmail(token);
    }

    public List<TasksDTOResponse> searchTasksByPeriod(LocalDateTime initialDate, LocalDateTime finalDate, String token) {
        return tasksClient.searchTasksByPeriod(initialDate, finalDate, token);
    }


    public TasksDTOResponse updateTasks(TasksDTORequest tasksDTO, String idTask, String token) {
        return tasksClient.updateTasks(tasksDTO, idTask, token);
    }

    public TasksDTOResponse changeNotificationStatus(String idTask, NotificationStatusEnum status, String token) {
        return tasksClient.changeNotificationStatus(idTask, status, token);
    }


}

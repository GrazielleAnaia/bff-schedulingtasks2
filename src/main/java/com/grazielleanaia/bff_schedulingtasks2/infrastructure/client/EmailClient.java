package com.grazielleanaia.bff_schedulingtasks2.infrastructure.client;


import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.TasksDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification", url = "${email.url}")
public interface EmailClient {


    @PostMapping
    void sendEmail(@RequestBody TasksDTOResponse tasksDTO);
}

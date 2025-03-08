package com.grazielleanaia.bff_schedulingtasks2.infrastructure.client;


import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.CustomerDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.LoginDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.PhoneDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.ResidenceDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.CustomerDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.PhoneDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.ResidenceDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "customer", url = "${customer.url}")
public interface CustomerClient {


    @GetMapping("/customer")
    CustomerDTOResponse findCustomerByEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    CustomerDTOResponse createCustomer(@RequestBody CustomerDTORequest customerDTO);

    @PostMapping("/login")
    String customerLogin(@RequestBody LoginDTORequest customerDTO);

    @DeleteMapping("/{email}")
    void deleteCustomerByEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    CustomerDTOResponse updateCustomerData(@RequestBody CustomerDTORequest customerDTO,
                                   @RequestHeader("Authorization") String token);

    @PutMapping("/residence")
    ResidenceDTOResponse updateResidence(@RequestBody ResidenceDTORequest residenceDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/phone")
    PhoneDTOResponse updatePhone(@RequestBody PhoneDTORequest phoneDTO,
                                 @RequestParam("id") Long id,
                                 @RequestHeader("Authorization") String token);

    @PostMapping("/residence")
    ResidenceDTOResponse addResidence(@RequestBody ResidenceDTORequest residenceDTO,
                              @RequestHeader("Authorization") String token);

    @PostMapping("/phone")
    PhoneDTOResponse addPhone(@RequestBody PhoneDTORequest phoneDTO,
                      @RequestHeader("Authorization") String token);


}

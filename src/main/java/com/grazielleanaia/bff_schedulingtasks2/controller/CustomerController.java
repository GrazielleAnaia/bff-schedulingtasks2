package com.grazielleanaia.bff_schedulingtasks2.controller;


import com.grazielleanaia.bff_schedulingtasks2.business.CustomerService;

import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.CustomerDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.LoginDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.PhoneDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.ResidenceDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.CustomerDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.PhoneDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.ResidenceDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer", description = "Registration and Customer Login")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)

public class CustomerController {
    private final CustomerService service;


    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @Operation(summary = "Save customer", description = "Create a new customer")
    @ApiResponse(responseCode = "200", description = "Customer successfully saved")
    @ApiResponse(responseCode = "400", description = "Customer already registered")
    @ApiResponse(responseCode = "500", description = "Server error")
    @PostMapping
    public ResponseEntity<CustomerDTOResponse> createCustomer(@RequestBody CustomerDTORequest customerDTO) {
        return ResponseEntity.ok(service.saveCustomer(customerDTO));
    }

    @Operation(summary = "Login customer", description = "Customer logged in")
    @ApiResponse(responseCode = "200", description = "Customer successfully logged in")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @ApiResponse(responseCode = "500", description = "Server error")
    @PostMapping("/login")
    public String customerLogin(@RequestBody LoginDTORequest customerDTO) {
        return service.loginCustomer(customerDTO);
    }

    @Operation(summary = "Search customer data by email", description = "Search customer by email")
    @ApiResponse(responseCode = "200", description = "Customer successfully found")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @GetMapping
    public ResponseEntity<CustomerDTOResponse>findCustomerByEmail(@RequestParam("email") String email,
                                                           @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.findCustomerByEmail(email, token));
    }

    @DeleteMapping("/{email}")

    @Operation(summary = "Delete customer by email", description = "Delete customer by email")
    @ApiResponse(responseCode = "200", description = "Customer successfully deleted")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable String email,
                                                      @RequestHeader(value = "Authorization", required = false) String token) {
        service.deleteCustomerByEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Update customer data", description = "Update customer data")
    @ApiResponse(responseCode = "200", description = "Customer successfully updated")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<CustomerDTOResponse> updateCustomerData(@RequestBody CustomerDTORequest customerDTO,
                                                          @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.updateCustomer(customerDTO, token));
    }

    @PutMapping("/residence")
    @Operation(summary = "Update customer address", description = "Update customer address")
    @ApiResponse(responseCode = "200", description = "Address successfully updated")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<ResidenceDTOResponse> updateResidence(@RequestBody ResidenceDTORequest residenceDTO,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.updateResidence(residenceDTO, id, token));
    }

    @PutMapping("/phone")
    @Operation(summary = "Update customer phone", description = "Update customer phone")
    @ApiResponse(responseCode = "200", description = "Phone successfully updated")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<PhoneDTOResponse> updatePhone(@RequestBody PhoneDTORequest phoneDTO,
                                                        @RequestParam("id") Long id,
                                                        @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.updatePhone(phoneDTO, id, token));
    }

    @PostMapping("/residence")
    @Operation(summary = "Register customer address", description = "Register customer address")
    @ApiResponse(responseCode = "200", description = "Address successfully saved")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<ResidenceDTOResponse> addResidence(@RequestBody ResidenceDTORequest residenceDTO,
                                                     @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.addResidence(residenceDTO, token));
    }

    @PostMapping("/phone")
    @Operation(summary = "Register customer phone", description = "Register customer phone")
    @ApiResponse(responseCode = "200", description = "Phone successfully saved")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<PhoneDTOResponse> addPhone(@RequestBody PhoneDTORequest phoneDTO,
                                             @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(service.addPhone(phoneDTO, token));
    }


}

package com.grazielleanaia.bff_schedulingtasks2.business;


import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.CustomerDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.LoginDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.PhoneDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.in.ResidenceDTORequest;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.CustomerDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.PhoneDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.business.dto.out.ResidenceDTOResponse;
import com.grazielleanaia.bff_schedulingtasks2.infrastructure.client.CustomerClient;

import org.springframework.stereotype.Service;

@Service

public class CustomerService {

    private final CustomerClient customerClient;

    public CustomerService(CustomerClient customerClient){
        this.customerClient = customerClient;
    }



    public CustomerDTOResponse saveCustomer(CustomerDTORequest customerDTO) {
    return customerClient.createCustomer(customerDTO);
    }

    public String loginCustomer(LoginDTORequest customerDTO) {
        return customerClient.customerLogin(customerDTO);
    }

    public CustomerDTOResponse findCustomerByEmail(String email, String token) {
       return customerClient.findCustomerByEmail(email, token);
    }

    public void deleteCustomerByEmail(String email, String token) {
        customerClient.deleteCustomerByEmail(email, token);
    }


    public CustomerDTOResponse updateCustomer(CustomerDTORequest customerDTO, String token) {
   return customerClient.updateCustomerData(customerDTO, token);
    }

    public ResidenceDTOResponse updateResidence(ResidenceDTORequest residenceDTO, Long id, String token) {
    return customerClient.updateResidence(residenceDTO, id, token);
    }

    public PhoneDTOResponse updatePhone(PhoneDTORequest phoneDTO, Long id, String token) {
 return customerClient.updatePhone(phoneDTO, id, token);
    }

    public ResidenceDTOResponse addResidence(ResidenceDTORequest residenceDTO, String token) {
   return customerClient.addResidence(residenceDTO, token);
    }

    public PhoneDTOResponse addPhone(PhoneDTORequest phoneDTO, String token) {
    return customerClient.addPhone(phoneDTO, token);
    }



}

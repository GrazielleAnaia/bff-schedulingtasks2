package com.grazielleanaia.bff_schedulingtasks2.business.dto.in;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomerDTORequest {

    private String name;

    private String email;

    private String password;

    List<PhoneDTORequest> phones;

    List<ResidenceDTORequest> residences;




}

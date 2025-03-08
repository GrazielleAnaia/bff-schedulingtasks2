package com.grazielleanaia.bff_schedulingtasks2.business.dto.in;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ResidenceDTORequest {


    private String street;


    private String city;

    private String state;

    private String zipCode;

}

package com.grazielleanaia.bff_schedulingtasks2.business.dto.out;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ResidenceDTOResponse {

    private Long id;

    private String street;


    private String city;

    private String state;

    private String zipCode;

}

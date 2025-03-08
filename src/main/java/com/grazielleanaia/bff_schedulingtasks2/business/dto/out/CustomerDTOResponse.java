package com.grazielleanaia.bff_schedulingtasks2.business.dto.out;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomerDTOResponse {

    private String name;

    private String email;

    private String password;

    List<PhoneDTOResponse> phones;

    List<ResidenceDTOResponse> residences;




}

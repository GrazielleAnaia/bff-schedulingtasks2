package com.grazielleanaia.bff_schedulingtasks2.business.dto.in;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PhoneDTORequest {

    private String number;

    private Long customer_id;


}

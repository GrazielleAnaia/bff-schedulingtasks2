package com.grazielleanaia.bff_schedulingtasks2.business.dto.out;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PhoneDTOResponse {

    private Long id;

    private String number;

    private Long customer_id;


}

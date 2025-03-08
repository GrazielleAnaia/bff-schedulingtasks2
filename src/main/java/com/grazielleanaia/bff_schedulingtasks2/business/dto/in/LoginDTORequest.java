package com.grazielleanaia.bff_schedulingtasks2.business.dto.in;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginDTORequest {

    private String email;

    private String password;
}

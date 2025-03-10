package com.grazielleanaia.bff_schedulingtasks2.business.dto.in;


import lombok.*;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor


@Builder

public class LoginDTORequest {

    private String email;

    private String password;

    public LoginDTORequest(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public LoginDTORequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

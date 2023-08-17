package com.ea.springbasic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDetails {

    private final String userEmail;
    private final String userPassword;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phoneCode;
    private String phoneNumber;
}

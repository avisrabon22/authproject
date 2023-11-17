package com.avijit.authproject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLoginDto {
    private String emailId;
    private String password;
    private String fullName;
}

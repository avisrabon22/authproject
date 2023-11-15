package com.avijit.authproject.Model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class User extends BaseModel{
    @NotNull
    private String emailId;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
}

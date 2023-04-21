package com.asamigas.api.dto.request;

import com.asamigas.api.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {

    private String email;
    private String password;
    private String userName;
    private Gender gender;
    private Date birthDate;

}

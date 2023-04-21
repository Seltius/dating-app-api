package com.dating.api.dto.request;

import com.dating.api.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RegisterUserRequest {
    //TODO ADD FIELD VALIDATIONS (JAVAX)

    private String email;
    private String password;
    private String nickName;
    private Gender gender;
    private Date birthDate;

}

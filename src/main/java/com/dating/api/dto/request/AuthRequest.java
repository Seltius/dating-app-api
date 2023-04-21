package com.dating.api.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequest {
    //TODO ADD FIELD VALIDATIONS (JAVAX)

    private String email;
    private String password;

}

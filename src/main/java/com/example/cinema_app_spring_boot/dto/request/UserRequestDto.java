package com.example.cinema_app_spring_boot.dto.request;

import com.example.cinema_app_spring_boot.lib.FieldsValueMatch;
import com.example.cinema_app_spring_boot.lib.ValidEmail;
import jakarta.validation.constraints.Size;
import lombok.Data;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Fields password don't match!")
@Data
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 6, max = 20)
    private String password;
    private String repeatPassword;
}

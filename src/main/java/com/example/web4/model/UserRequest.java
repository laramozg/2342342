package com.example.web4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {
    @Length(min = 6, max = 60)
    private String username;
    @Length(min = 2, max = 60)
    private String password;
}

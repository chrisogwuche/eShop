package com.decagon.eshop.dto;


import com.decagon.eshop.enums.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterationDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;


}

package com.webcrudapi.model.dto;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {
    private String email;
    private String firstName;
    private String lastName;

}

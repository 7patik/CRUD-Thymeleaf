package com.webcrudapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email",nullable = false,unique = true,length = 45)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "first_name",nullable = false,length = 45)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 45)
    private String lastName;
}

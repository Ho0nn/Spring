package com.springboot.jwtpractice.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;


}

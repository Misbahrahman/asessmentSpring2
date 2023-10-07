package com.example.assessment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.logging.Level;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String username;

    String email;

    String password;
}

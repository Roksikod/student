package org.example.student.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FrontTutor {
    private int id;
    private String firstName;
    private String lastName;
    private String description;
    private int age;
    private String city;
    private String nickTg;
    private String email;
}


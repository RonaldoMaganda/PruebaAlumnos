package com.example.student_management.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private int id;
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("email")
    private String correo;
    @JsonProperty("age")
    private int edad;
    @JsonProperty("course")
    private String curso;
}

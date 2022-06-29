package com.example.pocio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 148791981981L;

    private int age;
    private String name;
    private String lastName;
}

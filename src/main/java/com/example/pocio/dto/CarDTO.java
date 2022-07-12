package com.example.pocio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarDTO implements Serializable {

    private static final long serialVersionUID = 148791981982L;

    private String model;
    private String brand;
}

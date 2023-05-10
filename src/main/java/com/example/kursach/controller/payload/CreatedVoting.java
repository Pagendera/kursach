package com.example.kursach.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreatedVoting {
    private Long id;
    private String name;
    private String description;
    private List<CreatedPretendent> createdPretendents;
}

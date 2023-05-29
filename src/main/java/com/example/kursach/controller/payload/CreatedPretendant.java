package com.example.kursach.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatedPretendant {
    private Long id;
    private Long votingId;
    private String name;
    private String description;
    private Integer countOfVotes;
}

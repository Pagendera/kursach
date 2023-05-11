package com.example.kursach.controller.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatedVote {
    private Long id;
    private Long pretendantId;
    private String userId;
}

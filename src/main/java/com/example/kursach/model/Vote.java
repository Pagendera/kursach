package com.example.kursach.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VOTES")
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pretendent_id", nullable = false)
    private Pretendent pretendent;

}

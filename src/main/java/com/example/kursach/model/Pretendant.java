package com.example.kursach.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRETENDANTS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pretendant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "pretendant", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Vote> votes = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "voting_id", nullable = false)
    private Voting voting;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 1024)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pretendant that = (Pretendant) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

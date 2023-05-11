package com.example.kursach.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VOTINGS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Voting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "voting", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Pretendant> pretendants = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 2048)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Voting voting = (Voting) o;
        return getId() != null && Objects.equals(getId(), voting.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

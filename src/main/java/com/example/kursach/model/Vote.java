package com.example.kursach.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "VOTES", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "pretendant_id", "voting_id"}))
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pretendant_id",  nullable = false)
    private Pretendant pretendant;

    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "voting_id", nullable = false)
    private Voting voting;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vote vote = (Vote) o;
        return getId() != null && Objects.equals(getId(), vote.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

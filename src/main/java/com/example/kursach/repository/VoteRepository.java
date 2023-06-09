package com.example.kursach.repository;

import com.example.kursach.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    boolean existsByUserIdAndVotingId(Long userId, Long votingId);
}

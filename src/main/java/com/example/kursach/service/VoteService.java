package com.example.kursach.service;


import com.example.kursach.model.Vote;

import java.util.List;
import java.util.Optional;

public interface VoteService {
    Optional<Vote> findById(Long id);

    List<Vote> findAll();

    Vote save(Vote vote);

    Vote update(Vote vote);

    void deleteById(Long id);

    boolean existsByUserIdAndVotingId(Long userId, Long votingId);
}

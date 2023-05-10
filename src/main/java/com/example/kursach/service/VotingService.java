package com.example.kursach.service;


import com.example.kursach.model.Voting;

import java.util.List;
import java.util.Optional;

public interface VotingService {

    Optional<Voting> findById(Long id);

    List<Voting> findAll();

    Voting save(Voting voting);

    Voting update(Voting voting);

    void deleteById(Long id);
}

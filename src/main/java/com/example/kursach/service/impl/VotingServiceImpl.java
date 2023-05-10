package com.example.kursach.service.impl;


import com.example.kursach.model.Voting;
import com.example.kursach.repository.VoteRepository;
import com.example.kursach.repository.VotingRepository;
import com.example.kursach.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotingServiceImpl implements VotingService {

    private final VotingRepository votingRepository;

    @Override
    public Optional<Voting> findById(Long id) {
        return votingRepository.findById(id);
    }

    @Override
    public List<Voting> findAll() {
        return votingRepository.findAll();
    }

    @Override
    public Voting save(Voting voting) {
        return votingRepository.save(voting);
    }

    @Override
    public Voting update(Voting voting) {
        return votingRepository.save(voting);
    }

    @Override
    public void deleteById(Long id) {
        votingRepository.deleteById(id);
    }
}

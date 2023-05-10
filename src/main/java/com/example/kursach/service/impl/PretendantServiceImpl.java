package com.example.kursach.service.impl;

import com.example.kursach.model.Pretendant;
import com.example.kursach.repository.PretendentRepository;
import com.example.kursach.service.PretendantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PretendantServiceImpl implements PretendantService {

    private final PretendentRepository pretendantRepository;

    @Override
    public Optional<Pretendant> findById(Long id) {
        return pretendantRepository.findById(id);
    }

    @Override
    public List<Pretendant> findAll() {
        return pretendantRepository.findAll();
    }

    @Override
    public Pretendant save(Pretendant pretendant) {
        return pretendantRepository.save(pretendant);
    }

    @Override
    public Pretendant update(Pretendant pretendant) {
        return pretendantRepository.save(pretendant);
    }

    @Override
    public void deleteById(Long id) {
        pretendantRepository.deleteById(id);
    }
}

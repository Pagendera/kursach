package com.example.kursach.service.impl;

import com.example.kursach.model.Pretendent;
import com.example.kursach.repository.PretendentRepository;
import com.example.kursach.service.PretendentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PretendentServiceImpl implements PretendentService {

    private final PretendentRepository pretendentRepository;

    @Override
    public Optional<Pretendent> findById(Long id) {
        return pretendentRepository.findById(id);
    }

    @Override
    public List<Pretendent> findAll() {
        return pretendentRepository.findAll();
    }

    @Override
    public Pretendent save(Pretendent pretendent) {
        return pretendentRepository.save(pretendent);
    }

    @Override
    public Pretendent update(Pretendent pretendent) {
        return pretendentRepository.save(pretendent);
    }

    @Override
    public void deleteById(Long id) {
        pretendentRepository.deleteById(id);
    }
}

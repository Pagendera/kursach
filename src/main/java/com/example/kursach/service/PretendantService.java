package com.example.kursach.service;


import com.example.kursach.model.Pretendant;

import java.util.List;
import java.util.Optional;

public interface PretendantService {
    Optional<Pretendant> findById(Long id);

    List<Pretendant> findAll();

    Pretendant save(Pretendant pretendant);

    Pretendant update(Pretendant pretendant);

    void deleteById(Long id);
}

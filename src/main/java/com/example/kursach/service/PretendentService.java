package com.example.kursach.service;


import com.example.kursach.model.Pretendent;

import java.util.List;
import java.util.Optional;

public interface PretendentService {
    Optional<Pretendent> findById(Long id);

    List<Pretendent> findAll();

    Pretendent save(Pretendent pretendent);

    Pretendent update(Pretendent pretendent);

    void deleteById(Long id);
}

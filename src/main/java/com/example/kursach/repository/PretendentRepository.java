package com.example.kursach.repository;

import com.example.kursach.model.Pretendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PretendentRepository extends JpaRepository<Pretendant, Long> {
}

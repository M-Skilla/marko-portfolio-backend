package com.example.markoportfolio.repository;

import com.example.markoportfolio.model.Achievement;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, String> {

    Optional<Achievement> findByName(String name);

    boolean existsByName(String name);
}

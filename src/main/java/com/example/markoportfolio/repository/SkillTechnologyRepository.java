package com.example.markoportfolio.repository;

import com.example.markoportfolio.model.SkillTechnology;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillTechnologyRepository extends JpaRepository<SkillTechnology, String> {

    Optional<SkillTechnology> findByName(String name);

    boolean existsByName(String name);

    List<SkillTechnology> findByCategory(String category);
}

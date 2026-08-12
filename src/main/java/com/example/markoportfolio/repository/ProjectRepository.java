package com.example.markoportfolio.repository;

import com.example.markoportfolio.model.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    Optional<Project> findBySlug(String slug);

    boolean existsBySlug(String slug);
}

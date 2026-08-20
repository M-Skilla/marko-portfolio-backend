package com.example.markoportfolio.repository;

import com.example.markoportfolio.model.FormalEducation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormalEducationRepository extends JpaRepository<FormalEducation, String> {

    List<FormalEducation> findByInstitution(String institution);

    List<FormalEducation> findByDegree(String degree);
}

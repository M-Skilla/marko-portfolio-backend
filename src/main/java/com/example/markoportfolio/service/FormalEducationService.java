package com.example.markoportfolio.service;

import com.example.markoportfolio.dto.FormalEducationRequest;
import com.example.markoportfolio.model.FormalEducation;
import com.example.markoportfolio.repository.FormalEducationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FormalEducationService {

    private final FormalEducationRepository formalEducationRepository;

    public FormalEducationService(FormalEducationRepository formalEducationRepository) {
        this.formalEducationRepository = formalEducationRepository;
    }

    public List<FormalEducation> getAllEducation() {
        return formalEducationRepository.findAll();
    }

    public Optional<FormalEducation> getEducationById(String id) {
        return formalEducationRepository.findById(id);
    }

    public FormalEducation createEducation(FormalEducationRequest request) {
        FormalEducation education = FormalEducation.builder()
                .institution(request.getInstitution())
                .degree(request.getDegree())
                .fieldOfStudy(request.getFieldOfStudy())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .description(request.getDescription())
                .location(request.getLocation())
                .grade(request.getGrade())
                .build();
        return formalEducationRepository.save(education);
    }

    public Optional<FormalEducation> updateEducation(String id, FormalEducationRequest request) {
        return formalEducationRepository.findById(id)
                .map(existing -> {
                    existing.setInstitution(request.getInstitution());
                    existing.setDegree(request.getDegree());
                    existing.setFieldOfStudy(request.getFieldOfStudy());
                    existing.setStartDate(request.getStartDate());
                    existing.setEndDate(request.getEndDate());
                    existing.setDescription(request.getDescription());
                    existing.setLocation(request.getLocation());
                    existing.setGrade(request.getGrade());
                    return formalEducationRepository.save(existing);
                });
    }

    public boolean deleteEducation(String id) {
        if (!formalEducationRepository.existsById(id)) {
            return false;
        }
        formalEducationRepository.deleteById(id);
        return true;
    }
}

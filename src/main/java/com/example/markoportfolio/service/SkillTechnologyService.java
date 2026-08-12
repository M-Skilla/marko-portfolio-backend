package com.example.markoportfolio.service;

import com.example.markoportfolio.dto.SkillTechnologyRequest;
import com.example.markoportfolio.model.SkillTechnology;
import com.example.markoportfolio.repository.SkillTechnologyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SkillTechnologyService {

    private final SkillTechnologyRepository skillTechnologyRepository;

    public SkillTechnologyService(SkillTechnologyRepository skillTechnologyRepository) {
        this.skillTechnologyRepository = skillTechnologyRepository;
    }

    public List<SkillTechnology> getAllSkills() {
        return skillTechnologyRepository.findAll();
    }

    public Optional<SkillTechnology> getSkillById(String id) {
        return skillTechnologyRepository.findById(id);
    }

    public SkillTechnology createSkill(SkillTechnologyRequest request) {
        SkillTechnology skill = SkillTechnology.builder()
                .name(request.getName())
                .iconSvg(request.getIconSvg())
                .category(request.getCategory())
                .build();
        return skillTechnologyRepository.save(skill);
    }

    public Optional<SkillTechnology> updateSkill(String id, SkillTechnologyRequest request) {
        return skillTechnologyRepository.findById(id)
                .map(existing -> {
                    existing.setName(request.getName());
                    existing.setIconSvg(request.getIconSvg());
                    existing.setCategory(request.getCategory());
                    return skillTechnologyRepository.save(existing);
                });
    }

    public boolean deleteSkill(String id) {
        if (!skillTechnologyRepository.existsById(id)) {
            return false;
        }
        skillTechnologyRepository.deleteById(id);
        return true;
    }
}

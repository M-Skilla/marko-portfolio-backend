package com.example.markoportfolio.service;

import com.example.markoportfolio.dto.AchievementRequest;
import com.example.markoportfolio.model.Achievement;
import com.example.markoportfolio.repository.AchievementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;

    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }

    public Optional<Achievement> getAchievementById(String id) {
        return achievementRepository.findById(id);
    }

    public Achievement createAchievement(AchievementRequest request) {
        Achievement achievement = Achievement.builder()
                .name(request.getName())
                .imageUrl(request.getImageUrl())
                .description(request.getDescription())
                .achievedDate(request.getAchievedDate())
                .issuer(request.getIssuer())
                .build();
        return achievementRepository.save(achievement);
    }

    public Optional<Achievement> updateAchievement(String id, AchievementRequest request) {
        return achievementRepository.findById(id)
                .map(existing -> {
                    existing.setName(request.getName());
                    existing.setImageUrl(request.getImageUrl());
                    existing.setDescription(request.getDescription());
                    existing.setAchievedDate(request.getAchievedDate());
                    existing.setIssuer(request.getIssuer());
                    return achievementRepository.save(existing);
                });
    }

    public boolean deleteAchievement(String id) {
        if (!achievementRepository.existsById(id)) {
            return false;
        }
        achievementRepository.deleteById(id);
        return true;
    }
}

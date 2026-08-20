package com.example.markoportfolio.controller;

import com.example.markoportfolio.dto.AchievementRequest;
import com.example.markoportfolio.model.Achievement;
import com.example.markoportfolio.service.AchievementService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping
    public List<Achievement> getAllAchievements() {
        return achievementService.getAllAchievements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Achievement> getAchievementById(@PathVariable String id) {
        return achievementService.getAchievementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Achievement> createAchievement(@RequestBody AchievementRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(achievementService.createAchievement(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Achievement> updateAchievement(@PathVariable String id,
                                                         @RequestBody AchievementRequest request) {
        return achievementService.updateAchievement(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable String id) {
        return achievementService.deleteAchievement(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

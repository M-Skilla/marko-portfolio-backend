package com.example.markoportfolio.controller;

import com.example.markoportfolio.dto.SkillTechnologyRequest;
import com.example.markoportfolio.model.SkillTechnology;
import com.example.markoportfolio.service.SkillTechnologyService;
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
@RequestMapping("/skills")
public class SkillTechnologyController {

    private final SkillTechnologyService skillTechnologyService;

    public SkillTechnologyController(SkillTechnologyService skillTechnologyService) {
        this.skillTechnologyService = skillTechnologyService;
    }

    @GetMapping
    public List<SkillTechnology> getAllSkills() {
        return skillTechnologyService.getAllSkills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillTechnology> getSkillById(@PathVariable String id) {
        return skillTechnologyService.getSkillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SkillTechnology> createSkill(@RequestBody SkillTechnologyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(skillTechnologyService.createSkill(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillTechnology> updateSkill(@PathVariable String id,
                                                       @RequestBody SkillTechnologyRequest request) {
        return skillTechnologyService.updateSkill(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable String id) {
        return skillTechnologyService.deleteSkill(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

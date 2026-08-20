package com.example.markoportfolio.controller;

import com.example.markoportfolio.dto.FormalEducationRequest;
import com.example.markoportfolio.model.FormalEducation;
import com.example.markoportfolio.service.FormalEducationService;
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
@RequestMapping("/education")
public class FormalEducationController {

    private final FormalEducationService formalEducationService;

    public FormalEducationController(FormalEducationService formalEducationService) {
        this.formalEducationService = formalEducationService;
    }

    @GetMapping
    public List<FormalEducation> getAllEducation() {
        return formalEducationService.getAllEducation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormalEducation> getEducationById(@PathVariable String id) {
        return formalEducationService.getEducationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FormalEducation> createEducation(@RequestBody FormalEducationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(formalEducationService.createEducation(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormalEducation> updateEducation(@PathVariable String id,
                                                           @RequestBody FormalEducationRequest request) {
        return formalEducationService.updateEducation(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable String id) {
        return formalEducationService.deleteEducation(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

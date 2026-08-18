package com.example.markoportfolio.controller;

import com.example.markoportfolio.dto.ProjectMediaRequest;
import com.example.markoportfolio.model.ProjectMedia;
import com.example.markoportfolio.service.ProjectMediaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media")
public class ProjectMediaController {

    private final ProjectMediaService projectMediaService;

    public ProjectMediaController(ProjectMediaService projectMediaService) {
        this.projectMediaService = projectMediaService;
    }

    @GetMapping("/project/{projectId}")
    public List<ProjectMedia> getMediaByProjectId(@PathVariable String projectId) {
        return projectMediaService.getMediaByProjectId(projectId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectMedia> getMediaById(@PathVariable String id) {
        return projectMediaService.getMediaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/project/{projectId}")
    public ResponseEntity<ProjectMedia> createMedia(@PathVariable String projectId,
                                                    @RequestBody ProjectMediaRequest request) {
        return projectMediaService.createMedia(projectId, request)
                .map(media -> ResponseEntity.status(HttpStatus.CREATED).body(media))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable String id) {
        return projectMediaService.deleteMedia(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

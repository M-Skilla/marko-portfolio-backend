package com.example.markoportfolio.service;

import com.example.markoportfolio.dto.ProjectMediaRequest;
import com.example.markoportfolio.model.ProjectMedia;
import com.example.markoportfolio.repository.ProjectMediaRepository;
import com.example.markoportfolio.repository.ProjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProjectMediaService {

    private final ProjectMediaRepository projectMediaRepository;
    private final ProjectRepository projectRepository;

    public ProjectMediaService(ProjectMediaRepository projectMediaRepository,
                               ProjectRepository projectRepository) {
        this.projectMediaRepository = projectMediaRepository;
        this.projectRepository = projectRepository;
    }

    public List<ProjectMedia> getMediaByProjectId(String projectId) {
        return projectMediaRepository.findByProjectId(projectId);
    }

    public Optional<ProjectMedia> getMediaById(String id) {
        return projectMediaRepository.findById(id);
    }

    public Optional<ProjectMedia> createMedia(String projectId, ProjectMediaRequest request) {
        return projectRepository.findById(projectId)
                .map(project -> projectMediaRepository.save(
                        ProjectMedia.builder()
                                .project(project)
                                .mediaUrl(request.getMediaUrl())
                                .caption(request.getCaption())
                                .displayOrder(request.getDisplayOrder())
                                .build()));
    }

    public boolean deleteMedia(String id) {
        if (!projectMediaRepository.existsById(id)) {
            return false;
        }
        projectMediaRepository.deleteById(id);
        return true;
    }
}

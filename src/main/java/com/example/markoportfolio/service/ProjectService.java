package com.example.markoportfolio.service;

import com.example.markoportfolio.dto.ProjectMediaRequest;
import com.example.markoportfolio.dto.ProjectRequest;
import com.example.markoportfolio.model.Project;
import com.example.markoportfolio.model.ProjectMedia;
import com.example.markoportfolio.model.SkillTechnology;
import com.example.markoportfolio.repository.ProjectRepository;
import com.example.markoportfolio.repository.SkillTechnologyRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private static final String DEFAULT_SKILL_CATEGORY = "General";

    private final ProjectRepository projectRepository;
    private final SkillTechnologyRepository skillTechnologyRepository;

    public ProjectService(ProjectRepository projectRepository,
                          SkillTechnologyRepository skillTechnologyRepository) {
        this.projectRepository = projectRepository;
        this.skillTechnologyRepository = skillTechnologyRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectBySlug(String slug) {
        return projectRepository.findBySlug(slug);
    }

    public Project createProject(ProjectRequest request) {
        Project project = Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .techStack(request.getTechStack())
                .projectUrl(request.getProjectUrl())
                .repoUrl(request.getRepoUrl())
                .featuredImageUrl(request.getFeaturedImageUrl())
                .featured(request.isFeatured())
                .status(request.getStatus())
                .completedAt(request.getCompletedAt())
                .build();

        project.setSkills(resolveSkills(request.getSkills()));
        project.setMedia(buildMedia(project, request.getMedia()));

        return projectRepository.save(project);
    }

    public boolean deleteProject(String id) {
        if (!projectRepository.existsById(id)) {
            return false;
        }
        projectRepository.deleteById(id);
        return true;
    }

    /**
     * Resolves the given skill names into SkillTechnology entities, creating
     * any that do not already exist (with a default category).
     */
    private Set<SkillTechnology> resolveSkills(List<String> skillNames) {
        Set<SkillTechnology> skills = new HashSet<>();
        if (skillNames != null) {
            for (String skillName : skillNames) {
                SkillTechnology skill = skillTechnologyRepository.findByName(skillName)
                        .orElseGet(() -> skillTechnologyRepository.save(
                                SkillTechnology.builder()
                                        .name(skillName)
                                        .category(DEFAULT_SKILL_CATEGORY)
                                        .build()));
                skills.add(skill);
            }
        }
        return skills;
    }

    private List<ProjectMedia> buildMedia(Project project, List<ProjectMediaRequest> mediaRequests) {
        List<ProjectMedia> media = new ArrayList<>();
        if (mediaRequests != null) {
            for (ProjectMediaRequest mediaRequest : mediaRequests) {
                media.add(ProjectMedia.builder()
                        .project(project)
                        .mediaUrl(mediaRequest.getMediaUrl())
                        .caption(mediaRequest.getCaption())
                        .displayOrder(mediaRequest.getDisplayOrder())
                        .build());
            }
        }
        return media;
    }
}

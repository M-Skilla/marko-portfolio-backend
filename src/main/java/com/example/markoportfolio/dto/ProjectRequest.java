package com.example.markoportfolio.dto;

import com.example.markoportfolio.model.ProjectStatus;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequest {

    private String name;

    private String description;

    private String techStack;

    private String projectUrl;

    private String repoUrl;

    private String featuredImageUrl;

    private boolean featured;

    private ProjectStatus status;

    private LocalDateTime completedAt;

    private List<String> skills;

    private List<ProjectMediaRequest> media;
}

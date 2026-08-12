package com.example.markoportfolio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(name = "tech_stack")
    private String techStack;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "project_url")
    private String projectUrl;

    @Column(name = "repo_url")
    private String repoUrl;

    @Column(name = "featured_image_url")
    private String featuredImageUrl;

    @Column(name = "is_featured")
    private boolean featured;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProjectStatus status;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @ManyToMany
    @JoinTable(
            name = "project_skills",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillTechnology> skills = new HashSet<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectMedia> media = new ArrayList<>();

    private String slugify(String input) {
        return input.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .trim()
                .replaceAll("\\s+", "-");
    }

    @PrePersist
    private void generateSlug() {
        String base = slugify(this.name);
        this.slug = base + "-" + UUID.randomUUID().toString().substring(0, 5);
    }
}

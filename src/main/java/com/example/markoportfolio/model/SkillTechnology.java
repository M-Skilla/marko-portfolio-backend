package com.example.markoportfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills_technologies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "icon_svg", columnDefinition = "TEXT")
    private String iconSvg;

    @Column(nullable = false)
    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "skills")
    private Set<Project> projects = new HashSet<>();
}

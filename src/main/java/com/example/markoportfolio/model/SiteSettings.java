package com.example.markoportfolio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "site_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hero_title")
    private String heroTitle;

    @Column(name = "hero_subtitle", columnDefinition = "TEXT")
    private String heroSubtitle;

    @Column(name = "about_me", columnDefinition = "TEXT")
    private String aboutMe;

    @Column(name = "resume_url")
    private String resumeUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "twitter_url")
    private String twitterUrl;

    @Column(name = "linkedin_url")
    private String linkedInUrl;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description", columnDefinition = "TEXT")
    private String metaDescription;
}

package com.example.markoportfolio.service;

import com.example.markoportfolio.dto.SiteSettingsRequest;
import com.example.markoportfolio.model.SiteSettings;
import com.example.markoportfolio.repository.SiteSettingsRepository;
import org.springframework.stereotype.Service;

@Service
public class SiteSettingsService {

    private final SiteSettingsRepository siteSettingsRepository;

    public SiteSettingsService(SiteSettingsRepository siteSettingsRepository) {
        this.siteSettingsRepository = siteSettingsRepository;
    }

    /**
     * Returns the single site settings row. Since this table is expected to hold
     * only one record, the first row is returned. If none exists yet, a new
     * (unsaved) instance is returned.
     */
    public SiteSettings getSettings() {
        return siteSettingsRepository.findAll()
                .stream()
                .findFirst()
                .orElseGet(SiteSettings::new);
    }

    /**
     * Persists the given settings, reusing the existing singleton row (if any)
     * so that no duplicate rows are created.
     */
    public SiteSettings updateSettings(SiteSettingsRequest settings) {
        SiteSettings existing = siteSettingsRepository.findAll()
                .stream()
                .findFirst()
                .orElseGet(SiteSettings::new);

        existing.setHeroTitle(settings.getHeroTitle());
        existing.setHeroSubtitle(settings.getHeroSubtitle());
        existing.setAboutMe(settings.getAboutMe());
        existing.setResumeUrl(settings.getResumeUrl());
        existing.setGithubUrl(settings.getGithubUrl());
        existing.setTwitterUrl(settings.getTwitterUrl());
        existing.setLinkedInUrl(settings.getLinkedInUrl());
        existing.setMetaTitle(settings.getMetaTitle());
        existing.setMetaDescription(settings.getMetaDescription());

        return siteSettingsRepository.save(existing);
    }
}

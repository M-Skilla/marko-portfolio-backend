package com.example.markoportfolio.controller;

import com.example.markoportfolio.dto.SiteSettingsRequest;
import com.example.markoportfolio.model.SiteSettings;
import com.example.markoportfolio.service.SiteSettingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/site")
public class SiteSettingsController {

    private final SiteSettingsService siteSettingsService;

    public SiteSettingsController(SiteSettingsService siteSettingsService) {
        this.siteSettingsService = siteSettingsService;
    }

    @GetMapping
    public ResponseEntity<SiteSettings> getSettings() {
        return ResponseEntity.ok(siteSettingsService.getSettings());
    }

    @PostMapping
    public ResponseEntity<SiteSettings> updateSettings(@RequestBody SiteSettingsRequest siteSettingsRequest) {
        return ResponseEntity.ok(siteSettingsService.updateSettings(siteSettingsRequest));
    }


}

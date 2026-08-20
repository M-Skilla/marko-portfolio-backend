package com.example.markoportfolio.dto;

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
public class SiteSettingsRequest {

    private String heroTitle;

    private String heroSubtitle;

    private String aboutMe;

    private String resumeUrl;

    private String githubUrl;

    private String twitterUrl;

    private String linkedInUrl;

    private String phone;

    private String email;

    private String metaTitle;

    private String metaDescription;
}

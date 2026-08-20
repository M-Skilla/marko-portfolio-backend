package com.example.markoportfolio.dto;

import java.time.LocalDate;
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
public class AchievementRequest {

    private String name;

    private String imageUrl;

    private String description;

    private LocalDate achievedDate;

    private String issuer;
}

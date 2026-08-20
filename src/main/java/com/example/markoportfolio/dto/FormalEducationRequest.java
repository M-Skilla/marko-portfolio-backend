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
public class FormalEducationRequest {

    private String institution;

    private String degree;

    private String fieldOfStudy;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private String location;

    private String grade;
}

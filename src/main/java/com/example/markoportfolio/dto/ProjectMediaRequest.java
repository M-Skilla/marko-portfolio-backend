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
public class ProjectMediaRequest {

    private String mediaUrl;

    private String caption;

    private Integer displayOrder;
}

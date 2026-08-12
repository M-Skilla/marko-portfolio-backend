package com.example.markoportfolio.repository;

import com.example.markoportfolio.model.ProjectMedia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMediaRepository extends JpaRepository<ProjectMedia, String> {

    List<ProjectMedia> findByProjectId(String projectId);
}

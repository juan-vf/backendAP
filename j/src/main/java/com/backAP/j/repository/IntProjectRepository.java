package com.backAP.j.repository;

import com.backAP.j.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IntProjectRepository extends JpaRepository<Project, Integer> {

    Optional<Project> findByNameProject(String nameProject);
    public boolean existsByNameProject(String positionTitle);

}

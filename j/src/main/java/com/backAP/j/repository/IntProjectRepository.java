package com.backAP.j.repository;

import com.backAP.j.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntProjectRepository extends JpaRepository<Project, Integer> {

}

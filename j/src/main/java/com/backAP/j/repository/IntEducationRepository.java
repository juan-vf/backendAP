package com.backAP.j.repository;

import com.backAP.j.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntEducationRepository extends JpaRepository<Education, Integer> {

}

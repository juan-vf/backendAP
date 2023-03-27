package com.backAP.j.repository;

import com.backAP.j.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntExperienceRepository extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByPositionTitle(String positionTitle);
    public boolean existsByPositionTitle(String positionTitle);
}


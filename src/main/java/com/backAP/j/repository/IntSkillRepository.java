package com.backAP.j.repository;

import com.backAP.j.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntSkillRepository extends JpaRepository<Skill, Integer> {
    public Optional<Skill> findByNameSkill(String nameSkill);
    public boolean existsByNameSkill(String nameSkill);

}

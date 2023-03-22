package com.backAP.j.repository;

import com.backAP.j.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntSkillRepository extends JpaRepository<Skill, Integer> {

}

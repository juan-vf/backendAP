package com.backAP.j.repository;

import com.backAP.j.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntEducationRepository extends JpaRepository<Education, Integer> {

    public Optional<Education> findByTittle(String tittle);
    public boolean existsByTittle(String tittle);

}

package com.backAP.j.repository;

import com.backAP.j.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntAboutRepository extends JpaRepository<About, Integer> {
    public Optional<About> findByTittleAbout(String tittleAbout);
    public boolean existsByTittleAbout(String tittleAbout);

}

package com.backAP.j.repository;

import com.backAP.j.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntAboutRepository extends JpaRepository<About, Integer> {

}

package com.backAP.j.repository;

import com.backAP.j.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntPersonRepository extends JpaRepository<Person, Integer> {

}

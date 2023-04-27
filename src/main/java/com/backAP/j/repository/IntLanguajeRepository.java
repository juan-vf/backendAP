package com.backAP.j.repository;

import com.backAP.j.entity.Languaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntLanguajeRepository extends JpaRepository<Languaje, Integer> {
    public Optional<Languaje> findByLanguaje(String languaje);
    public boolean existsByLanguaje(String languaje);
}

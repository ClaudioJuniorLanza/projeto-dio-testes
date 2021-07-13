package com.digitalinnovation.project.refritests.repository;

import com.digitalinnovation.project.refritests.entities.Refrigerante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefriRepository extends JpaRepository<Refrigerante, Long> {

    Optional<Refrigerante> findByName(String name);

}

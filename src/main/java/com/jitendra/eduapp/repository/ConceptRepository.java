package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jitendra.eduapp.domin.Concept;

@Repository(value="concept")
public interface ConceptRepository extends JpaRepository<Concept, Long>{

}

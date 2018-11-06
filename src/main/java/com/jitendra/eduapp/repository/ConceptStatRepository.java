package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitendra.eduapp.domin.ConceptStat;
import com.jitendra.eduapp.domin.key.ConceptStatPrimeryKey;

public interface ConceptStatRepository extends JpaRepository<ConceptStat, ConceptStatPrimeryKey> {

}

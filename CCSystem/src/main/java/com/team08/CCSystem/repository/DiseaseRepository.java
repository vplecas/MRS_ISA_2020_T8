package com.team08.CCSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team08.CCSystem.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

}
package com.enviro.assessment.grad001.phillimonmotsinoni.repository;

import com.enviro.assessment.grad001.phillimonmotsinoni.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
}

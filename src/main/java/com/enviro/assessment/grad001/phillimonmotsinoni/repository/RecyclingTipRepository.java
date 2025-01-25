package com.enviro.assessment.grad001.phillimonmotsinoni.repository;

import com.enviro.assessment.grad001.phillimonmotsinoni.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
}

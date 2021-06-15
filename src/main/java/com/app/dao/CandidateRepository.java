package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}

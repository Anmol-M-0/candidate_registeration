package com.app.service;

import com.app.dto.CandidateDTO;
import com.app.pojos.Candidate;

public interface CandidateService {
	Candidate saveCandidateInfo(CandidateDTO dto);
}

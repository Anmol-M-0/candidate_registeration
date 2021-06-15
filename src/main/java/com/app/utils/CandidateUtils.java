package com.app.utils;

import com.app.dto.CandidateDTO;
import com.app.pojos.Candidate;

public interface CandidateUtils {

	static Candidate fetchCandidate(CandidateDTO dto) {
		return new Candidate(dto.getName(), dto.getPartyName(), null, dto.getDob(), dto.getEmail(), dto.getAddress(),
				dto.getPhoneNumber());
	}

}

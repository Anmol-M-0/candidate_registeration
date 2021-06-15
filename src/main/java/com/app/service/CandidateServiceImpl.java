package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.dao.CandidateRepository;
import com.app.dao.PartyRepository;
import com.app.dto.CandidateDTO;
import com.app.exceptions.PartyException;
import com.app.pojos.Candidate;
import com.app.pojos.Party;
import static com.app.utils.CandidateUtils.*;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private AddressRepository addressRepository;
	public Candidate saveCandidateInfo(CandidateDTO dto) {
		System.out.println("fetching party");
		Party party = partyRepository.findOneByPartyName(dto.getPartyName())
				.orElseThrow(() -> new PartyException("could not find the requested result"));
		System.out.println("cand dto to pojo");
		Candidate candidate = new Candidate(dto.getName(), dto.getPartyName(), null, dto.getDob(), dto.getEmail(),addressRepository.save(dto.getAddress()),
				dto.getPhoneNumber());
		candidate.setParty(party);
		System.out.println("setting cand party");
		System.out.println("set candidate party");
		System.out.println("saving cand");
		candidateRepository.save(candidate);
		System.out.println("saved candidate");
		return candidate;

	}

}

package com.app.service;

import static com.app.utils.PartyUtils.fetchParty;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.dao.PartyDescriptionRepository;
import com.app.dao.PartyRepository;
import com.app.dto.PartyDTO;
import com.app.exceptions.PartyException;
import com.app.pojos.Party;
import com.app.pojos.PartyDescription;

@Service
@Transactional
public class PartyServiceImpl implements PartyService {
	@Autowired
	private PartyRepository partyRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PartyDescriptionRepository descriptionRepository;

	@Override
	public Party saveParty(PartyDTO dto) {
		Party party = partyRepository.save(new Party(dto.getPartyName(), dto.getAgenda(), dto.getEmail(),
				descriptionRepository.save(dto.getPartyDescription()), addressRepository.save(dto.getOfficeAddress()),
				dto.getContactNumber()));
		return party;
	}

	@Override
	public Party findById(Long id) {
		return partyRepository.findById(id).orElseThrow(()-> new PartyException("could not find the requested result"));
	}

	@Override
	public Party findByName(String name) {
		return partyRepository.findOneByPartyName(name).orElseThrow(()-> new PartyException("invalid name"));
	}

}

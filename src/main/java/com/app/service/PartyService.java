package com.app.service;

import com.app.dto.PartyDTO;
import com.app.pojos.Party;

public interface PartyService {

	Party saveParty(PartyDTO partyDTO);

	Party findById(Long id);
	
	Party findByName(String name);
	

}

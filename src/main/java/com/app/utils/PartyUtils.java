package com.app.utils;

import com.app.dto.PartyDTO;
import com.app.pojos.Party;

public interface PartyUtils {

	static Party fetchParty(PartyDTO dto) {
		new Party();
		return new Party(dto.getPartyName(), dto.getAgenda(), dto.getPartyDescription(), dto.getOfficeAddress(),
				dto.getContactNumber(), null, null, dto.getEmail());
	}

}

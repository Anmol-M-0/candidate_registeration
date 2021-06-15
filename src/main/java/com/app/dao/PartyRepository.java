package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Party;
@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

	Optional<Party> findOneByPartyName(String partyName);
}

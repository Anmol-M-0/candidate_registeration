package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.PartyDescription;
@Repository
public interface PartyDescriptionRepository extends JpaRepository<PartyDescription, Long> {

}

package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parties")
public class Party extends BaseEntity {
	@Column(length = 50,nullable = false, unique = true)
	private String partyName;
	// symbol - how to describe?
	@Column(length = 100)
	private String agenda;
	@Column(length = 20,nullable = false, unique = true)
	private String email;
//ALIGNMENT ? NO	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="party_description_id")
	private PartyDescription partyDescription;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = false)
	@JoinColumn(name = "office_address_id")
	private Address officeAddress;
	@Embedded
	private PhoneNumber contactNumber;
	@OneToMany(mappedBy = "party", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<Candidate> candidates = new HashSet<>();
	@OneToMany(mappedBy = "party", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Member> members = new HashSet<>();

	public Party(Long id) {
		super(id);
	}

	public Party() {
	}



	public Party(String partyName, String agenda, PartyDescription description, Address officeAddress, PhoneNumber contactNumber,
			Set<Candidate> candidates, Set<Member> members, String email) {
		super();
		this.partyName = partyName;
		this.agenda = agenda;
		this.partyDescription = description;
		this.officeAddress = officeAddress;
		this.contactNumber = contactNumber;
		this.candidates = candidates;
		this.members = members;
		this.email = email;
	}
	

	public Party(String partyName, String agenda, String email, PartyDescription partyDescription,
			Address officeAddress, PhoneNumber contactNumber) {
		super();
		this.partyName = partyName;
		this.agenda = agenda;
		this.email = email;
		this.partyDescription = partyDescription;
		this.officeAddress = officeAddress;
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PartyDescription getPartyDescription() {
		return partyDescription;
	}

	public void setPartyDescription(PartyDescription partyDescription) {
		this.partyDescription = partyDescription;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	

	public PhoneNumber getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(PhoneNumber contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Party other = (Party) obj;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Party [partyName=" + partyName + ", agenda=" + agenda + "]";
	}

}

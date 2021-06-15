package com.app.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.app.pojos.Address;
import com.app.pojos.PersonName;
import com.app.pojos.PhoneNumber;

public class CandidateDTO {
	private PersonName name;
	private String partyName;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
	private String email;
	private Address address;
	private PhoneNumber phoneNumber;
	public CandidateDTO() {
	}
	public CandidateDTO(PersonName name, String partyName,  LocalDate dob, String email,Address address,
			PhoneNumber phoneNumber) {
		super();
		this.name = name;
		this.partyName = partyName;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return name.getFirstName()+" "+name.getMiddleName()+" "+name.getLastName();
	}
	public PersonName getName() {
		return name;
	}
	public void setName(PersonName name) {
		this.name = name;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateDTO other = (CandidateDTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CandidateDTO [name=" + name + ", partyName=" + partyName + ", dob=" + dob + ", email=" + email
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
}

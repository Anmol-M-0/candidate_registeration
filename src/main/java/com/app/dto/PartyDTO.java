package com.app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.app.pojos.Address;
import com.app.pojos.BaseEntity;
import com.app.pojos.PartyDescription;
import com.app.pojos.PhoneNumber;

public class PartyDTO {
		private String partyName;
		private String agenda;
		private PartyDescription partyDescription;
		private String email;
		private Address officeAddress;
		private PhoneNumber contactNumber;
		public PartyDTO() {
			// TODO Auto-generated constructor stub
		}
		public PartyDTO(String partyName, String agenda, PartyDescription partyDescription, Address officeAddress,
				PhoneNumber contactNumber, String email) {
			super();
			this.partyName = partyName;
			this.agenda = agenda;
			this.partyDescription = partyDescription;
			this.officeAddress = officeAddress;
			this.contactNumber = contactNumber;
			this.email = email;
		}
	
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public PartyDescription getPartyDescription() {
			return partyDescription;
		}
		public void setPartyDescription(PartyDescription partyDescription) {
			this.partyDescription = partyDescription;
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
			int result = 1;
			result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
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
			PartyDTO other = (PartyDTO) obj;
			if (partyName == null) {
				if (other.partyName != null)
					return false;
			} else if (!partyName.equals(other.partyName))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "PartyDTO [partyName=" + partyName + ", agenda=" + agenda + ", partyDescription=" + partyDescription
					+ ", officeAddress=" + officeAddress + ", contactNumber=" + contactNumber + "]";
		}
		
}

package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
//Use @AssociationOverrides (for entity relations) or @AttributeOverrides (for simple attributes) –
//https://docs.oracle.com/javaee/7/api/javax/persistence/AssociationOverrides.html
//https://docs.oracle.com/javaee/7/api/javax/persistence/AttributeOverrides.html
@Embeddable
public class PhoneNumber {
	@Column(length =  13)
	private String phoneNumber;
	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PhoneNumber(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		PhoneNumber other = (PhoneNumber) obj;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phoneNumber=" + phoneNumber + "]";
	}

}

package com.intel.binding;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

//@Data
public class ContactForm {

	private int contactId;
	private String contactName;
	private Long contactNumber;
	private String contatcEmail;
	private String activeSw;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContatcEmail() {
		return contatcEmail;
	}
	public void setContatcEmail(String contatcEmail) {
		this.contatcEmail = contatcEmail;
	}
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activeSw, contactId, contactName, contactNumber, contatcEmail, createdDate, updatedDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactForm other = (ContactForm) obj;
		return Objects.equals(activeSw, other.activeSw) && contactId == other.contactId
				&& Objects.equals(contactName, other.contactName) && Objects.equals(contactNumber, other.contactNumber)
				&& Objects.equals(contatcEmail, other.contatcEmail) && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(updatedDate, other.updatedDate);
	}
	@Override
	public String toString() {
		return "ContactForm [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber="
				+ contactNumber + ", contatcEmail=" + contatcEmail + ", activeSw=" + activeSw + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
}

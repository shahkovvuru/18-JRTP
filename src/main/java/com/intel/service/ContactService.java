package com.intel.service;

import java.util.List;

import com.intel.binding.ContactForm;

public interface ContactService {
	
	public String saveContact(ContactForm form);

	public List<ContactForm> viewContacts();
	
	public ContactForm editContact(int contactId);
	
	public List<ContactForm> deleteContact(int contactId);
}

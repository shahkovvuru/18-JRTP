package com.intel.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intel.binding.ContactForm;
import com.intel.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		String status = contactService.saveContact(form);
		return status;
	}
	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts(){
		System.out.println("JMeter request to viewContacts()...!");
		return contactService.viewContacts();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		  ContactForm form = contactService.editContact(contactId);
		  return form;	
	}
	
	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId){
		return contactService.deleteContact(contactId);
	}
}

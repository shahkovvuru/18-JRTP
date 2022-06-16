package com.intel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intel.binding.ContactForm;
import com.intel.entity.Contact;
import com.intel.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {

		/*
		 * we are getting form binding object as perameter but, repository
		 * save(entity)is expecting entity object copy data from form binding object to
		 * entity object
		 */

		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSw("Y");
		entity = contactRepo.save(entity);
		if (entity.getContactId() != null) {
			return "SUCCESS";
		}
		return "FAILED";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> dataList = new ArrayList<>();

		List<Contact> findAll = contactRepo.findAll();
		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(int contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
		//	System.out.println("Editable object" +form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(int contactId) {
		contactRepo.deleteById(contactId);
		// return viewContacts(); // it will return all the records available in DB.
		// Boiler plate coding....
		List<ContactForm> dataList = new ArrayList<>();

		List<Contact> findAll = contactRepo.findAll();
		for (Contact entity : findAll) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

}

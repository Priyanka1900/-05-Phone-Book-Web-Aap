package com.ashok.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.dto.Contact;
import com.ashok.entity.ContactEntity;
import com.ashok.repo.ContactDetlsRepository;


@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDetlsRepository contactRepo;

	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();
		if (c.getContactId() != null) {
			Optional<ContactEntity> findById = contactRepo.findById(c.getContactId());
			entity = findById.get();
		}
		BeanUtils.copyProperties(c, entity);
		ContactEntity savedEntity = contactRepo.save(entity);
		/* return savedEntity.getContactId()!=null; */
		return savedEntity.getContactId() != null;

	}

	public List<Contact> getAllContacts() {

		List<ContactEntity> entities = contactRepo.findAll();

		// Legacy approach(converting entity to model obj)

		/*
		 * List<Contact>contacts=new ArrayList<Contact>(); for(ContactEntity
		 * entity:entities) {//getting one entity Contact contact=new
		 * Contact();//copying o the contact BeanUtils.copyProperties(entity,
		 * contact);//add to the collection contacts.add(contact); } return contacts; }
		 */

		// java 8 (using stream)
		List<Contact> contacts = entities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		return contacts;
	}

	public Contact getContactById(Integer cid) {
		// to get record without having pk
		Optional<ContactEntity> findById = contactRepo.findById(cid);
		if (findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}

	public boolean UpdateContact(Contact c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}

}

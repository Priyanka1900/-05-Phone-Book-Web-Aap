package com.ashok.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ashok.dto.Contact;
import com.ashok.entity.ContactEntity;

public interface ContactService {
	boolean saveContact(Contact c);
	List<Contact>getAllContacts();
	Contact getContactById(Integer cid);
	boolean UpdateContact(Contact c);
	boolean deleteContact(Integer cid);
}

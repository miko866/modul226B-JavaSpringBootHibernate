package managersystem.server.Services;

import managersystem.server.entities.Contact;
import managersystem.server.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;


	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void deleteContact(Contact contact) {
		contactRepository.delete(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return contactRepository.getOne(id);
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Boolean existsById(int id) {
		return contactRepository.existsById(id);
	}
}

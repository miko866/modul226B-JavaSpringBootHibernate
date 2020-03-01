package managersystem.server.Services;

import managersystem.server.entities.Contact;

import java.util.List;

public interface ContactService {

	Contact saveContact(Contact contact);

	Contact updateContact(Contact contact);

	void deleteContact(Contact contact);

	Contact getContactById(int id);

	List<Contact> getAllContacts();

	Boolean existsById(int id);
}

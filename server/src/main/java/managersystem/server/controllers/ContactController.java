package managersystem.server.controllers;

import managersystem.server.Services.ContactService;
import managersystem.server.entities.Contact;
import managersystem.server.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4300")
@RestController
public class ContactController {

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	ContactService contactService;

	@GetMapping("/contactClient/{client_id}")
	public List<Contact> getContactAddress(@PathVariable("client_id") Integer client_id) {
		return contactRepository.getContactAddress(client_id);
	}

	@PostMapping
	@RequestMapping("/saveContact")
	public int saveContact(@ModelAttribute("contact")Contact contact, ModelMap modelMap) {
		Contact contactSaved = contactRepository.save(contact);
		return contactSaved.getId();
	}

	@PostMapping
	@RequestMapping(value= "/deleteContact/{id}")
	public boolean deleteContact(@PathVariable("id") int id) {
		Contact contact = contactService.getContactById(id);
		contactService.deleteContact(contact);
		return contactService.existsById(id);
	}

}

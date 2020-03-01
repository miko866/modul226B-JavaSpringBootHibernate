package managersystem.server.controllers;

import managersystem.server.Services.AddressService;
import managersystem.server.Services.ClientService;
import managersystem.server.Services.ContactService;
import managersystem.server.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4300")
@RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/allClients")
	public List<Client> listClients() { return clientService.getAllClients();}

	@PostMapping
	@RequestMapping("/saveClient")
	public int saveClient(@ModelAttribute("client")Client client, ModelMap modelMap) {
		Client clientSaved = clientService.saveClient(client);
		return clientSaved.getId();
	}

	@PostMapping
	@RequestMapping(value= "/deletClient/{id}")
	public boolean deleteClient(@PathVariable("id") int id) {
		Client client = clientService.getClientById(id);
		clientService.deleteClient(client);
		return clientService.existsById(id);
	}


}

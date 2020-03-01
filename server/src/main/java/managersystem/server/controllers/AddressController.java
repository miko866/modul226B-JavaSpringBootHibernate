package managersystem.server.controllers;

import managersystem.server.Services.AddressService;
import managersystem.server.entities.Address;
import managersystem.server.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4300")
@RestController
public class AddressController {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	AddressService addressService;

	@GetMapping("/addressClient/{client_id}")
	public List<Address> getClientAddress(@PathVariable("client_id") Integer client_id) {
		return addressRepository.getClientAddress(client_id);
	}

	@PostMapping
	@RequestMapping("/saveAddress")
	public int saveAddress(@ModelAttribute("address")Address address, ModelMap modelMap) {
		Address addressSaved = addressRepository.save(address);
		return addressSaved.getId();
	}

	@PostMapping
	@RequestMapping(value= "/deleteAddress/{id}")
	public boolean deleteAddress(@PathVariable("id") int id) {
		Address address = addressService.getAddressById(id);
		addressService.deleteAddress(address);
		return addressService.existsById(id);
	}

}

package managersystem.server.Services;

import managersystem.server.entities.Address;
import managersystem.server.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;


	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddress(Address address) {
		addressRepository.delete(address);
	}

	@Override
	public Address getAddressById(int id) {
		return addressRepository.getOne(id);
	}

	@Override
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public Boolean existsById(int id) {
		return addressRepository.existsById(id);
	}
}

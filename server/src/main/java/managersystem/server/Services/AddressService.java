package managersystem.server.Services;

import managersystem.server.entities.Address;

import java.util.List;

public interface AddressService {

	Address saveAddress(Address address);

	Address updateAddress(Address address);

	void deleteAddress(Address address);

	Address getAddressById(int id);

	List<Address> getAllAddresses();

	Boolean existsById(int id);

}

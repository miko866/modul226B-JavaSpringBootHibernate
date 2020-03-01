package managersystem.server.Services;

import managersystem.server.entities.Client;
import managersystem.server.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;


	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public Client getClientById(int id) {
		return clientRepository.getOne(id);
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Boolean existsById(int id) {
		return clientRepository.existsById(id);
	}
}

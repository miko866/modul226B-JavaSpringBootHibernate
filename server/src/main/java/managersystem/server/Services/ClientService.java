package managersystem.server.Services;

import managersystem.server.entities.Client;

import java.util.List;

public interface ClientService {

	Client saveClient(Client client);

	Client updateClient(Client client);

	void deleteClient(Client client);

	Client getClientById(int id);

	List<Client> getAllClients();

	Boolean existsById(int id);
}

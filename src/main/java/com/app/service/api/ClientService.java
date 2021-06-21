package com.app.service.api;

import java.util.List;

import com.app.model.Client;

public interface ClientService
{
	void addClient(Client client);

	Client findClientById(Long id);

	void deleteClient(Client client);

	void deleteClientById(Long carId);

	List<Client> findAllClient();
}

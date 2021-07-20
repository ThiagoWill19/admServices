package com.thiagowill.admServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.admServices.entities.Client;
import com.thiagowill.admServices.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Client findById(int id) {
		return clientRepository.findById(id).get(); 
	}
	
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	public void deleteById(int id) {
		clientRepository.deleteById(id);
	}
}

package org.carrental.service;

import lombok.RequiredArgsConstructor;
import org.carrental.exception.CarNotFoundException;
import org.carrental.exception.ValidationException;
import org.carrental.model.Client;
import org.carrental.repository.ClientRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(Client client){
        if (client.getName().isBlank()){
            throw new ValidationException("Cannot be blank", "name");
        }
        if (client.getSurname().isBlank()){
            throw new ValidationException("Cannot be blank", "surname");
        }

        clientRepository.create(client);

        return client;
    }

    public Client getById(Integer id){
        Optional<Client> client = clientRepository.getById(id);

        return client.orElseThrow(() ->  new CarNotFoundException("Client does not exist"));
    }


}

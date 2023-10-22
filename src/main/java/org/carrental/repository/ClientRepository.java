package org.carrental.repository;

import org.carrental.model.Client;
import org.carrental.model.ClientClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository {
    List<Client> clientList = new ArrayList<>();

    public Client create(Client client){
        client.setId(clientList.size());
        clientList.add(client);

        return client;
    }

    public Optional<Client> getById(Integer id){
        return clientList.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }
    public Optional<Client> getBySurname(String surname){
        return clientList.stream()
                .filter(client -> client.getSurname().equals(surname))
                .findFirst();
    }

    public List<Client> getAll(){
        return clientList;
    }

    public List<Client> getByClientClassVIP(List<Client> clientList){
        return clientList.stream()
                .filter(client -> client.getClientClass().equals(ClientClass.VIP))
                .toList();
    }

    public void removeAll(){
        clientList = new ArrayList<>();
    }

    public void removeById(Integer id){
        Optional<Client> optionalClient = getById(id);

        optionalClient.ifPresent(it -> clientList.remove(it));
    }
}

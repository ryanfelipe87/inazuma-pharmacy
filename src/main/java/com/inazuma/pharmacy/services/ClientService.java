package com.inazuma.pharmacy.services;

import com.inazuma.pharmacy.dtos.ClientDto;
import com.inazuma.pharmacy.models.Client;
import com.inazuma.pharmacy.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public ClientDto createClient(ClientDto clientDto){
        Client client = convertoToEntity(clientDto);
        client = clientRepository.save(client);
        return convertToDto(client);
    }

    public List<ClientDto> listAll(){
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ClientDto convertToDto(Client client){
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(client, clientDto);
        return clientDto;
    }

    private Client convertoToEntity(ClientDto clientDto){
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return client;
    }
}

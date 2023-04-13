/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.service.impl;

import mag.grig.entity.Client;
import mag.grig.repository.ClientRepository;
import mag.grig.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * client service impl
 */
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    /**
     * Instantiates a new Client service.
     *
     * @param clientRepository the client repository
     */
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * @param Id
     * @return
     */
    @Override
    public Client getClientById(Long Id) {
        return clientRepository.findById(Id).orElse(null);
    }

    /**
     * @return
     */
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * @param client
     */
    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}

package mag.grig.service;

import mag.grig.entity.Client;

import java.util.List;

public interface ClientService {
    Client getClientById(Long Id);

    List<Client> getAllClients();

    void saveClient(Client client);
}

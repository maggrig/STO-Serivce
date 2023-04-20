package mag.grig.service;

import mag.grig.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    void saveClient(Client client);

    List<Client> findAll();

    Client findById(Long id);

    Long findIdByName(String name);
}

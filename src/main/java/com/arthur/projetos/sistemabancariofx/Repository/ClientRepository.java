package com.arthur.projetos.sistemabancariofx.Repository;

import com.arthur.projetos.sistemabancariofx.Model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientRepository {

   public Client findById(Long id);

   public List<Client> findAll();

   public void createClient(Client client) throws SQLException;

   public void deleteClientById(Long id);

   public void update(Client client, Long id);
}

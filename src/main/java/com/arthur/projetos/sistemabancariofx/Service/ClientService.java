package com.arthur.projetos.sistemabancariofx.Service;

import com.arthur.projetos.sistemabancariofx.Config.Gateway;
import com.arthur.projetos.sistemabancariofx.Config.SenhaUtils;
import com.arthur.projetos.sistemabancariofx.Model.Client;
import com.arthur.projetos.sistemabancariofx.Repository.ClientRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClientService implements ClientRepository {

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public void createClient(Client client) throws SQLException {

       try {
           String sql = "INSERT INTO clientes(name, cpf, password, account, gender) VALUES (?, ?, ?, ?::account, ?::gender)";
           PreparedStatement ps = Gateway.getConnection().prepareStatement(sql);
           ps.setString(1, client.getName());
           ps.setString(2, client.getCpf());
           ps.setString(3, SenhaUtils.hashSenha(client.getPassword()));
           ps.setString(4, client.getAccount().name());
           ps.setString(5, client.getGender().name());
           ps.executeUpdate();

       } catch (SQLException e){
           e.printStackTrace();
           System.out.println("Error: " + e.getMessage());

       }
    }

    @Override
    public void deleteClientById(Long id) {

    }
}

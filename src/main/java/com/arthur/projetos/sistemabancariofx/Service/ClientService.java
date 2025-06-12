package com.arthur.projetos.sistemabancariofx.Service;

import com.arthur.projetos.sistemabancariofx.Config.Gateway;
import com.arthur.projetos.sistemabancariofx.Config.SenhaUtils;
import com.arthur.projetos.sistemabancariofx.Enums.Account;
import com.arthur.projetos.sistemabancariofx.Enums.Gender;
import com.arthur.projetos.sistemabancariofx.Model.Client;
import com.arthur.projetos.sistemabancariofx.Repository.ClientRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements ClientRepository {

    @Override
    public Client findById(Long id) {
        Client client = null;

        try {
            ResultSet rs = null;
            String sql = "SELECT * FROM clientes WHERE id =?";
            PreparedStatement ps = Gateway.getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                client.setAge(rs.getInt("age"));
                client.setAccount(Account.valueOf(rs.getString("account")));
                client.setGender(Gender.valueOf(rs.getString("gender")));

                System.out.println("Id: " + client.getId() + " - Nome: " + client.getName() + " - Conta: " + client.getAccount());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }

        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();

        try {
            ResultSet rs = null;
            String sql = "SELECT * FROM clientes";
            PreparedStatement ps = Gateway.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                client.setAge(rs.getInt("age"));
                client.setAccount(Account.valueOf(rs.getString("account")));
                client.setGender(Gender.valueOf(rs.getString("gender")));


                clients.add(client);
                System.out.println("Id: " + client.getId() + " - Nome: " + client.getName() + " - Conta: " + client.getAccount());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }


        return clients;
    }

    @Override
    public void createClient(Client client) throws SQLException {

        try {
            String sql = "INSERT INTO clientes(name, cpf, password, account, gender, age) VALUES (?, ?, ?, ?::account_new, ?::gender, ?)";
            PreparedStatement ps = Gateway.getConnection().prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, SenhaUtils.hashSenha(client.getPassword()));
            ps.setString(4, client.getAccount().name());
            ps.setString(5, client.getGender().name());
            ps.setInt(6, client.getAge());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

        }
    }

    @Override
    public void deleteClientById(Long id) {

        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement ps = Gateway.getConnection().prepareStatement(sql);
            ps.setLong(1, id);

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected == 0) {
                System.out.println("Não existe usuario com esse id cadastrado.");
            } else {
                System.out.println("Usuario com o id: " + id + " deletado com sucesso.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Client client, Long id) {
        try {
            String sql = "UPDATE clientes SET name=?, cpf=?, password=?, account=?::account_new, gender=?::gender_new, age=? WHERE id =?";
            PreparedStatement ps = Gateway.getConnection().prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getCpf());
            ps.setString(3, SenhaUtils.hashSenha(client.getPassword()));
            ps.setString(4, client.getAccount().name());
            ps.setString(5, client.getGender().name());
            ps.setInt(6, client.getAge());
            ps.setLong(7, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

        }
    }
}

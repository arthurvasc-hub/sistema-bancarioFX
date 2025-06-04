package com.arthur.projetos.sistemabancariofx;

import com.arthur.projetos.sistemabancariofx.Enums.Account;
import com.arthur.projetos.sistemabancariofx.Enums.Gender;
import com.arthur.projetos.sistemabancariofx.Model.Client;
import com.arthur.projetos.sistemabancariofx.Service.ClientService;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {
        Client client = new Client();

        client.setName("Mamofi Vasconcelos");
        client.setCpf("8888888888");
        client.setPassword("mamofi123");
        client.setAccount(Account.POUPANÇA);
        client.setGender(Gender.MASCULINO);

         ClientService clientService = new ClientService();

        clientService.createClient(client);
    }
}

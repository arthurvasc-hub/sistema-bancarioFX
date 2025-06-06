package com.arthur.projetos.sistemabancariofx;

import com.arthur.projetos.sistemabancariofx.Enums.Account;
import com.arthur.projetos.sistemabancariofx.Enums.Gender;
import com.arthur.projetos.sistemabancariofx.Model.Client;
import com.arthur.projetos.sistemabancariofx.Service.ClientService;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {

        ClientService clientService = new ClientService();

        Client client = new Client();
        client.setName("Tutu");
        client.setCpf("99999999999");
        client.setPassword("Arthur008");
        client.setAccount(Account.POUPANCA);
        client.setGender(Gender.MASCULINO);


        clientService.findById(1L);



    }

}

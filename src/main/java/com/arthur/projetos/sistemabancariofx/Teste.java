package com.arthur.projetos.sistemabancariofx;

import com.arthur.projetos.sistemabancariofx.Enums.Account;
import com.arthur.projetos.sistemabancariofx.Enums.Gender;
import com.arthur.projetos.sistemabancariofx.Model.Client;
import com.arthur.projetos.sistemabancariofx.Service.ClientService;

import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {

        ClientService clientService = new ClientService();



        clientService.deleteClientById(3L);



    }

}

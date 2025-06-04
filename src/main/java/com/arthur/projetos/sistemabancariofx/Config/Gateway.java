package com.arthur.projetos.sistemabancariofx.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gateway {

    private static final String URL = "jdbc:postgresql://localhost:5432/sistemafx";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException("Erro ao obter conexão: " + e.getMessage());
        }
    }


    public static void closeConnection(Connection connection) throws SQLException {
        if(connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


}

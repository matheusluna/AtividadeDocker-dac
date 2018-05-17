/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.fabricas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author matheus
 */
public class ConnectionFactory {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://host-banco:5432/atividade";
        String usuario = "postgres";
        String senha = "123456";

        return DriverManager.getConnection(url, usuario, senha);
    }
}

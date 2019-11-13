/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final String DATABASE_NAME = "loja_informatica";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASS = "";
    private static final String DATABASE_PORT = "3306";

    private static Connection connection;
    private static Statement statement;
    

    public static Statement getInstance() {
        if (statement == null) {
            try {
                final String connectionString = "jdbc:mysql://localhost:" + DATABASE_PORT + "/" + DATABASE_NAME;
                connection = DriverManager.getConnection(connectionString, DATABASE_USER, DATABASE_PASS);
                statement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return statement;
    }
}

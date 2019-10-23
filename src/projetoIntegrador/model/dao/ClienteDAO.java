/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetoIntegrador.model.database.Database;
import projetoIntegrador.model.entity.Cliente;

/**
 *
 * @author Luciana Alves
 */
public class ClienteDAO {

    private static final String TABLE_NAME = "cliente";
    private Statement statement = Database.getInstance();

    public List<Cliente> findCustomerByName( String name) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE nome LIKE '%" + name + "%'";
        List<Cliente> customers = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String nome = rs.getString("nome");
               
                Cliente customer = new Cliente();              
                customer.setNome(nome);
                customers.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
}



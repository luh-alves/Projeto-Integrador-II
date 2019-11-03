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
import java.util.Collection;
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
//    private Statement statement = Database.getInstance();

    List<Cliente> clientes = new ArrayList<>();

    public ClienteDAO() {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Luiz");
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Andre");
        Cliente cliente3 = new Cliente();
        cliente3.setNome("Joana");
        Cliente cliente4 = new Cliente();
        cliente4.setNome("João");
        Cliente cliente5 = new Cliente();
        cliente5.setNome("Sabá");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);

    }

    public List<Cliente> pesquisarClientePorNome(String name) {

        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().contains(name.toLowerCase())) {
                resultado.add(cliente);
            }
        }
        return resultado;

//        String query = "SELECT * FROM " + TABLE_NAME + " WHERE nome LIKE '%" + name + "%'";
//        List<Cliente> customers = new ArrayList<>();
//        try {
//            ResultSet rs = statement.executeQuery(query);
//
//            while (rs.next()) {
//                String nome = rs.getString("nome");
//               
//                Cliente customer = new Cliente();              
//                customer.setNome(nome);
//                customers.add(customer);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //return customers;
    }
}

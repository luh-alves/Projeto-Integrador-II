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
 * @author geovane.saraujo
 */
public class ClienteDAO {
    
    //Salvar cliente no banco de dados simulado, apenas o objeto e se for "salvo corretamento" retorna como true nesse banco sempre i´ra retorna como true
     public static boolean salvarCliente(Cliente objCliente) {
        //simular uma inserção no bando de dados
        return SimulaBancoDados.getInstance().salvarCliente(objCliente);
    }
     
     //aqui é busca uma arrayList do tipo string do simulaBanco e manda para a view passar para a tabela
       public static ArrayList<Cliente> ConsultarClientes() {
        return SimulaBancoDados.getInstance().consultarCliente();
   }
       
       //atulliza o cliente enviando o objeto para o simula banco
        public static boolean atualizarCliente(Cliente objCliente) {
        return SimulaBancoDados.getInstance().atualizarCliente(objCliente);
  }
        //exclui o cliente passando o cpf(codigo de identificação) para o bancoSimulado procurar e excluir o cliente desejado 
     public static boolean excluirCliente(int id) {
       return SimulaBancoDados.getInstance().excluirCliente(id);
     }

     
    private static final String TABLE_NAME = "cliente";
//    private Statement statement = Database.getInstance();

    public List<Cliente> pesquisarClientePorNome(String name) {

        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : SimulaBancoDados.getInstance().consultarCliente()) {
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

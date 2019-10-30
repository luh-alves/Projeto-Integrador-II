/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.ArrayList;
import java.util.Date;
import projetoIntegrador.model.dao.ClienteDAO;
import projetoIntegrador.model.entity.Cliente;

/**
 *
 * @author Luciana Alves
 */
public class ClienteController {
    
    public static boolean salvarCliente(String cpf, String nome,String sexo, Date dataNascimento,String estadoCivil,String endereco, String email, String telefone) {
        Cliente cliente= new Cliente(cpf, nome, sexo, dataNascimento, estadoCivil, endereco, email, telefone);
        return ClienteDAO.salvarCliente(cliente);
    }
    
    public static ArrayList<String[]> consultarClientes() {
        ClienteDAO clienteConsultar = new ClienteDAO();
        ArrayList<String[]> ListarClientesString = new ArrayList<String[]>();

        
        
        for (Cliente ListarCliente: clienteConsultar.ConsultarClientes()){
            ListarClientesString.add(new String[]{String.valueOf(ListarCliente.getCpf()),
                ListarCliente.getNome(),
                String.valueOf(ListarCliente.getSexo()),
                String.valueOf(ListarCliente.getDataNascimento()),
                ListarCliente.getEstadoCivil(),
                ListarCliente.getEndereco(),
                ListarCliente.getEmail(),
                ListarCliente.getTelefone()});
        }
        return ListarClientesString;
    }

    public static boolean atualizarCliente() {
        Cliente clienteAtualizar = new Cliente();
        return ClienteDAO.atualizarCliente(clienteAtualizar);
    }

    public static boolean excluirCliente(String cpf) {
        return ClienteDAO.excluirCliente(cpf);
    }

    private ClienteDAO customerDAO = new ClienteDAO();

}

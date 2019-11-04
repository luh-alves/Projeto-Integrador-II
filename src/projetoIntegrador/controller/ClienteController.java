/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import projetoIntegrador.model.dao.ClienteDAO;
import static projetoIntegrador.model.dao.ClienteDAO.ConsultarClientes;
import projetoIntegrador.model.entity.Cliente;

/**
 *
 * @author geovane.saraujo
 */
public class ClienteController {

    public static boolean salvarCliente(String cpf, String nome, int sexo, Date dataNascimento, int estadoCivil, String endereco, String bairro, String cep, String numero, String cidade, String nacionalidade, String email, String telefone, String telefone2, Date dataCadastro, Date ultimaAtualizacao) {
        Cliente cliente = new Cliente(cpf, nome, sexo, dataNascimento, estadoCivil, endereco, bairro, cep, numero, cidade, nacionalidade, email, telefone, telefone2, dataCadastro,ultimaAtualizacao);
        return ClienteDAO.salvarCliente(cliente);
    }

    public static ArrayList<String[]> consultarClientes(String modo, String buscar) {
        ArrayList<String[]> ListarClientesString = new ArrayList<String[]>();
        
        for (Cliente ListarCliente : ConsultarClientes()) {
//           if(ListarCliente.getCpf().equals(buscar) && modo.equals("BuscarCPF") || ListarCliente.getNome().toLowerCase().contains(buscar.toLowerCase()) && modo.equals("BuscarNome")){
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy | HH:mm:ss");
            ListarClientesString.add(new String[]{
                String.valueOf(ListarCliente.getId()),
                ListarCliente.getNome(),
                ListarCliente.getCpf(),
                String.valueOf(ListarCliente.getSexo()),
                formato.format(ListarCliente.getDataNascimento()),
                String.valueOf(ListarCliente.getEstadoCivil()),
                ListarCliente.getEndereco(),
                ListarCliente.getBairro(),
                ListarCliente.getCep(),
                ListarCliente.getNumero(),
                ListarCliente.getCidade(),
                ListarCliente.getNacionalidade(),
                ListarCliente.getEmail(),
                ListarCliente.getTelefone(),
                ListarCliente.getTelefone2(),
               formato2.format(ListarCliente.getDataCadastro()),
               formato2.format(ListarCliente.getUltimaAtualizacao())});
        }
//        }
        return ListarClientesString;
    }
    
    public static ArrayList<String[]> buscarClientes(String buscar, String modo) {
         ArrayList<String[]> buscarClientesString = new ArrayList<>();
        for (Cliente ListarCliente : ConsultarClientes()) {
            
          
            if(ListarCliente.getCpf().equals(buscar) && modo.equals("BuscarCPF") || ListarCliente.getNome().toLowerCase().contains(buscar.toLowerCase()) && modo.equals("BuscarNome")){
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy | HH:mm:ss");
            buscarClientesString.add(new String[]{
                String.valueOf(ListarCliente.getId()),
                ListarCliente.getNome(),
                ListarCliente.getCpf(),
                String.valueOf(ListarCliente.getSexo()),
                formato.format(ListarCliente.getDataNascimento()),
                String.valueOf(ListarCliente.getEstadoCivil()),
                ListarCliente.getEndereco(),
                ListarCliente.getBairro(),
                ListarCliente.getCep(),
                ListarCliente.getNumero(),
                ListarCliente.getCidade(),
                ListarCliente.getNacionalidade(),
                ListarCliente.getEmail(),
                ListarCliente.getTelefone(),
                ListarCliente.getTelefone2(),
               formato2.format(ListarCliente.getDataCadastro()),
               formato2.format(ListarCliente.getUltimaAtualizacao())});
        }
        }
        return buscarClientesString;
    }

    public static boolean atualizarCliente(int id, String nome, int sexo, Date dataNascimento, int estadoCivil, String endereco, String bairro, String cep, String numero, String cidade, String nacionalidade, String email, String telefone, String telefone2, Date ultimaAtualizacao) {
        Cliente clienteAtualizar = new Cliente(id, nome, sexo, dataNascimento, estadoCivil, endereco, bairro, cep, numero, cidade, nacionalidade, email, telefone, telefone2, ultimaAtualizacao);
        return ClienteDAO.atualizarCliente(clienteAtualizar);
    }

    public static boolean excluirCliente(int id) {
        return ClienteDAO.excluirCliente(id);
    }

    private ClienteDAO customerDAO = new ClienteDAO();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import projetoIntegrador.dao.ClienteDAO;
import projetoIntegrador.model.Cliente;

/**
 *
 * @author geovane.saraujo
 */
public class ClienteController {

    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final String[] tradutorSexo = new String[]{"Feminino", "Masculino", "Indefinido"};
    private final String[] tradutorEstadoCivil = new String[]{"Solteiro", "Casado", "Divorciado"};

    //metodo usado para retornar o indice referente ao sexo do cliente e assim carregar na tela o sexo que foi cadastrado 
    public int traduzirSexo(String sexoSelecionado) {
        return java.util.Arrays.asList(tradutorSexo).indexOf(sexoSelecionado);
    }

    //metodo usado para retornar o indice referente ao Estado Civil do cliente e assim carregar na tela o Estado Civil que foi cadastrado 
    public int traduzirEstadoCivil(String estadoCivilSelecionado) {
        return java.util.Arrays.asList(tradutorEstadoCivil).indexOf(estadoCivilSelecionado);
    }
    
//metodo que recebe por parametro os dados do cliente e cria um novo objeto cliente a ser enviar para o clienteDAO que faz a persistencia no banco de dados
    public boolean salvarCliente(String cpf, String nome, int sexo,
            Date dataNascimento, int estadoCivil, String endereco,
            String bairro, String cep, String numero, String cidade,
            String nacionalidade, String email, String telefone,
            String telefone2, Date dataCadastro, Date ultimaAtualizacao) {

        Cliente cliente = new Cliente(cpf, nome, tradutorSexo[sexo], dataNascimento,
                tradutorEstadoCivil[estadoCivil], endereco, bairro, cep, numero,
                cidade, nacionalidade, email, telefone, telefone2, dataCadastro,
                ultimaAtualizacao);

        return clienteDAO.salvarCliente(cliente);
    }
    
    //metodo que chama o clienteDAO que fez a busca e adicionou em um ArrayLIst todos os cliente do banco de dados
    public ArrayList<String[]> consultarClientes() {
        ArrayList<String[]> listarClientesString = new ArrayList<>();

        //for que converte o ArrayList do tipo Cliente para um arrayList do tipo String
        for (Cliente cliente : clienteDAO.consultarClientes()) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            listarClientesString.add(new String[]{
                String.valueOf(cliente.getId()),
                cliente.getNome(),
                cliente.getCpf(),
                String.valueOf(traduzirSexo(cliente.getSexo())),
                formato.format(cliente.getDataNascimento()),
                String.valueOf(traduzirEstadoCivil(cliente.getEstadoCivil())),
                cliente.getEndereco(),
                cliente.getBairro(),
                cliente.getCep(),
                cliente.getNumero(),
                cliente.getCidade(),
                cliente.getNacionalidade(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getTelefone2(),
                formato.format(cliente.getDataCadastro()),
                formato.format(cliente.getUltimaAtualizacao())});
        }
        //é feito o retorno para a view um arrayList do tipo String
        return listarClientesString; 
    }

    //metodo que chama o clienteDAO que fez a busca e adicionou em um ArrayLIst todos os cliente do banco de dados 
    public ArrayList<String[]> buscarClientes(String buscar, String modo) {
        ArrayList<String[]> buscarClientesString = new ArrayList<>();
        //for que percorre todos que o clienteDAO pegou do banco de dados
        for (Cliente ListarCliente : clienteDAO.consultarClientes()) {
            //if que verifica o tipo de busca e retorna para a view o cliente de acordo com o que foi informado para o usuario
            if (ListarCliente.getCpf().equals(buscar) && modo.equals("BuscarCPF") || ListarCliente.getNome().toLowerCase().contains(buscar.toLowerCase()) && modo.equals("BuscarNome")||buscar.equals("")) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                buscarClientesString.add(new String[]{
                    String.valueOf(ListarCliente.getId()),
                    ListarCliente.getNome(),
                    ListarCliente.getCpf(),
                    String.valueOf(traduzirSexo(ListarCliente.getSexo())),
                    formato.format(ListarCliente.getDataNascimento()),
                    String.valueOf(traduzirEstadoCivil(ListarCliente.getEstadoCivil())),
                    ListarCliente.getEndereco(),
                    ListarCliente.getBairro(),
                    ListarCliente.getCep(),
                    ListarCliente.getNumero(),
                    ListarCliente.getCidade(),
                    ListarCliente.getNacionalidade(),
                    ListarCliente.getEmail(),
                    ListarCliente.getTelefone(),
                    ListarCliente.getTelefone2(),
                    formato.format(ListarCliente.getDataCadastro()),
                    formato.format(ListarCliente.getUltimaAtualizacao())});
            }
        }
        //retorna os clientes que buscado em um ArrayList do tipo String para a view 
        return buscarClientesString;
    }

    //metodo que recebe por parâmetro os dados do clienete a ser atualizado
    public boolean atualizarCliente(int id,String cpf, String nome, int sexo, Date dataNascimento,
            int estadoCivil, String endereco, String bairro, String cep,
            String numero, String cidade, String nacionalidade, String email,
            String telefone, String telefone2, Date ultimaAtualizacao) {

        //criar o objeto Cliente com os dados a ser atualizado
        Cliente clienteAtualizar = new Cliente(id, cpf, nome, tradutorSexo[sexo],
                dataNascimento, tradutorEstadoCivil[estadoCivil], endereco, bairro,
                cep, numero, cidade, nacionalidade, email, telefone, telefone2,
                ultimaAtualizacao);
       //envia para o clienteDAO, o objeto Cliente a ser a atualizado
        return clienteDAO.atualizarCliente(clienteAtualizar);
    }
    
    //envia para o clienteDAO o id do cliente que o usuario deseja excluir
    public boolean excluirCliente(int id) {
        return clienteDAO.excluirCliente(id);
    }

}

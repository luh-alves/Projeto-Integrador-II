/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoIntegrador.model.Cliente;
import projetoIntegrador.utils.Database;

/**
 *
 * @author geovane.saraujo
 */
public class ClienteDAO {

    //Salvar cliente no banco de dados simulado, apenas o objeto e se for "salvo corretamento" retorna como true nesse banco sempre i´ra retorna como true
    public boolean salvarCliente(Cliente objCliente) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (cpf, nome, sexo, email, telefone, telefone2, data_nascimento, estado_civil, rua, numero,"
                    + "bairro, cidade, cep, nacionalidade, data_cadastro, ultima_atualizacao) VALUES(?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, objCliente.getCpf());
            instrucaoSQL.setString(2, objCliente.getNome());
            instrucaoSQL.setString(3, objCliente.getSexo());
            instrucaoSQL.setString(4, objCliente.getEmail());
            instrucaoSQL.setString(5, objCliente.getTelefone());
            instrucaoSQL.setString(6, objCliente.getTelefone2());
            instrucaoSQL.setDate(7, new Date(objCliente.getDataNascimento().getTime()));
            instrucaoSQL.setString(8, objCliente.getEstadoCivil());
            instrucaoSQL.setString(9, objCliente.getEndereco());
            instrucaoSQL.setString(10, objCliente.getNumero());
            instrucaoSQL.setString(11, objCliente.getBairro());
            instrucaoSQL.setString(12, objCliente.getCidade());
            instrucaoSQL.setString(13, objCliente.getCep());
            instrucaoSQL.setString(14, objCliente.getNacionalidade());
            instrucaoSQL.setDate(15, new Date(objCliente.getUltimaAtualizacao().getTime()));
            instrucaoSQL.setDate(16, new Date(objCliente.getDataCadastro().getTime()));

            instrucaoSQL.executeUpdate(); //sintetico executeQuery
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {

            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                Database.fecharConexao();

            } catch (SQLException ex) {
            }
        }
    }

    //aqui busca uma arrayList do tipo Cliente do simulaBanco e manda para o controler passar para a view
    public ArrayList<Cliente> consultarClientes() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        try {

            conexao = Database.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente;");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setCpf(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setTelefone2(rs.getString("telefone2"));
                c.setDataNascimento(rs.getDate("data_nascimento"));
                c.setEstadoCivil(rs.getString("estado_civil"));
                c.setEndereco(rs.getString("rua"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setCep(rs.getString("cep"));
                c.setNacionalidade(rs.getString("nacionalidade"));
                c.setDataCadastro(rs.getDate("data_cadastro"));
                c.setUltimaAtualizacao(rs.getDate("ultima_atualizacao"));
                listaClientes.add(c);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                Database.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaClientes;
    }

//atulliza o cliente enviando o objeto para o simula banco
    public boolean atualizarCliente(Cliente objCliente) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, sexo = ?,"
                    + "email = ?, telefone = ?, telefone2 = ?, data_nascimento = ?, estado_civil = ?, rua = ?,"
                    + "numero = ?, bairro = ?, cidade = ?, cep = ?, nacionalidade = ?, ultima_atualizacao = ? WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, objCliente.getNome());
            instrucaoSQL.setString(2, objCliente.getSexo());
            instrucaoSQL.setString(3, objCliente.getEmail());
            instrucaoSQL.setString(4, objCliente.getTelefone());
            instrucaoSQL.setString(5, objCliente.getTelefone2());
            instrucaoSQL.setDate(6, new Date(objCliente.getDataNascimento().getTime()));
            instrucaoSQL.setString(7, objCliente.getEstadoCivil());
            instrucaoSQL.setString(8, objCliente.getEndereco());
            instrucaoSQL.setString(9, objCliente.getNumero());
            instrucaoSQL.setString(10, objCliente.getBairro());
            instrucaoSQL.setString(11, objCliente.getCidade());
            instrucaoSQL.setString(12, objCliente.getCep());
            instrucaoSQL.setString(13, objCliente.getNacionalidade());
            instrucaoSQL.setDate(14, new Date(objCliente.getUltimaAtualizacao().getTime()));
            instrucaoSQL.setInt(15, objCliente.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {

            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                Database.fecharConexao();

            } catch (SQLException ex) {
            }
        }
    }

    //exclui o cliente passando o cpf(codigo de identificação) para o bancoSimulado procurar e excluir o cliente desejado 
    public boolean excluirCliente(int id) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, id);

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {

            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                Database.fecharConexao();

            } catch (SQLException ex) {
            }
        }
    }

    public List<Cliente> pesquisarClientePorNome(String name) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {

            conexao = Database.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente where nome like ?;");
            instrucaoSQL.setString(1, "%" + name + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTelefone2(rs.getString("telefone2"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setEstadoCivil(rs.getString("estado_civil"));
                cliente.setEndereco(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNacionalidade(rs.getString("nacionalidade"));
                cliente.setDataCadastro(rs.getDate("data_cadastro"));
                cliente.setUltimaAtualizacao(rs.getDate("ultima_atualizacao"));
                listaClientes.add(cliente);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                Database.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaClientes;
    }

    public Cliente pesquisarClientePorId(int id) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = Database.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente where id = ?;");
            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTelefone2(rs.getString("telefone2"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setEstadoCivil(rs.getString("estado_civil"));
                cliente.setEndereco(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNacionalidade(rs.getString("nacionalidade"));
                cliente.setDataCadastro(rs.getDate("data_cadastro"));
                cliente.setUltimaAtualizacao(rs.getDate("ultima_atualizacao"));

                return cliente;
            }
            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            //Libero os recursos da memória
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                Database.fecharConexao();

            } catch (SQLException ex) {
            }
        }
    }

    public Cliente pesquisarClientePorId(int id, Connection conexao) {

        ResultSet rs = null;
        PreparedStatement instrucaoSQL = null;

        try {
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente where id = ?;");
            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTelefone2(rs.getString("telefone2"));
                cliente.setDataNascimento(rs.getDate("data_nascimento"));
                cliente.setEstadoCivil(rs.getString("estado_civil"));
                cliente.setEndereco(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNacionalidade(rs.getString("nacionalidade"));
                cliente.setDataCadastro(rs.getDate("data_cadastro"));
                cliente.setUltimaAtualizacao(rs.getDate("ultima_atualizacao"));

                return cliente;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}

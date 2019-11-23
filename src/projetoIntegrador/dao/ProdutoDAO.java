/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetoIntegrador.utils.Database;
import projetoIntegrador.model.Produto;

public class ProdutoDAO {

    public boolean salvar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome, quantidade, valor) VALUES(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setInt(2, p.getQuantidade());
            instrucaoSQL.setDouble(3, p.getValor());

            int linhasAfetadas = instrucaoSQL.executeUpdate(); //sintetico executeQuery

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); //Recupero o ID do cliente
                if (generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID do cliente.");
                }
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
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

        return retorno;
    }

    public boolean atualizar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome = ?, quantidade = ?, valor = ? WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
            System.out.println(p.getId());
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setInt(2, p.getQuantidade());
            instrucaoSQL.setDouble(3, p.getValor());
            instrucaoSQL.setInt(4, p.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
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

        return retorno;
    }

    public boolean atualizar(Produto p, Connection conexao) {
        boolean retorno = false;
        PreparedStatement instrucaoSQL = null;

        try {

            instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome = ?, quantidade = ?, valor = ? WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
            System.out.println(p.getId());
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setInt(2, p.getQuantidade());
            instrucaoSQL.setDouble(3, p.getValor());
            instrucaoSQL.setInt(4, p.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        }

        return retorno;
    }

    public boolean excluir(int pID) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, pID);

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
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

        return retorno;
    }

    public List<Produto> pesquisarProdutoPorNome(String name) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Produto> listaClientes = new ArrayList<Produto>();

        try {

            conexao = Database.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto where nome like ?;");
            instrucaoSQL.setString(1, "%" + name + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Produto c = new Produto();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setQuantidade(rs.getInt("quantidade"));
                c.setValor(rs.getDouble("valor"));
                listaClientes.add(c);
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

    public ArrayList<Produto> consultarProdutos() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Produto> listaClientes = new ArrayList<Produto>();

        try {

            conexao = Database.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto;");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Produto c = new Produto();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setQuantidade(rs.getInt("quantidade"));
                c.setValor(rs.getDouble("valor"));
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

}

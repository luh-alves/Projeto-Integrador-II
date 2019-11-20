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

    public static boolean salvar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome_prod, quantidade_prod, valor_prod) VALUES(?, ?, ?)",
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

    public static boolean atualizar(Produto p) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome_prod = ?, quantidade_prod = ?, valor_prod = ? WHERE id_prod = ?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente
            System.out.println(p.getId());
            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setInt(2, p.getQuantidade());
            instrucaoSQL.setDouble(3, p.getValor());
            instrucaoSQL.setInt(4, p.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

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

    public static boolean excluir(int pID) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Tenta estabeler a conexão com o SGBD e cria comando a ser executado conexão
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = Database.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE id_prod = ?",
                    Statement.RETURN_GENERATED_KEYS);  //Caso queira retornar o ID do cliente

            //Adiciono os parâmetros ao meu comando SQL
            instrucaoSQL.setInt(1, pID);

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

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

//    private static final String TABLE_NAME = "produto";
//    private static Object statement;
//
//    public List<Produto> pesquisarProdutoPorNome(String name) {
//
//        List<Produto> resultadoP = new ArrayList<>();
//        for (Produto produto : SimulaBancoDados.getInstance().consultarProduto()) {
//            if (produto.getNome().toLowerCase().contains(name.toLowerCase())) {
//                resultadoP.add(produto);
//            }
//        }
//        return resultadoP;
//    }
//    //daqui p baixo codigo wellington
//    public static boolean salvarP(Produto p) {
//
//        return SimulaBancoDados.getInstance().salvarProduto(p);
//    }
//
//    public static boolean atualizarP(Produto p) {
//
//        return SimulaBancoDados.getInstance().atualizarProduto(p);
//    }
//
//    public static boolean excluirP(int pID) {
//
//        return SimulaBancoDados.getInstance().excluirProduto(pID);
//
//    }
//
//    public static ArrayList<Produto> getProdutos() {
//
//        return SimulaBancoDados.getInstance().consultarProduto();
//
//    }
    public static ArrayList<Produto> consultarProdutos() {
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
                c.setId(rs.getInt("id_prod"));
                c.setNome(rs.getString("nome_prod"));
                c.setQuantidade(rs.getInt("quantidade_prod"));
                c.setValor(rs.getDouble("valor_prod"));
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

}

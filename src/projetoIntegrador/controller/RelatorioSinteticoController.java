/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import projetoIntegrador.dao.VendaDAO;
import projetoIntegrador.model.Venda;
import projetoIntegrador.model.Cliente;
import projetoIntegrador.utils.Database;

/**
 *
 * @author Luciana Alves
 */
public class RelatorioSinteticoController {

    public static ArrayList<Venda> consultarVendas(Date inicio, Date fim, Venda v) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<Venda> listaVendas = new ArrayList<Venda>();

        try {

            conexao = Database.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM venda BETWEEN ? AND ?");

            instrucaoSQL.setDate(1, (java.sql.Date) v.getDataVenda());

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                Venda c = new Venda();
                c.setId(rs.getInt("id_venda"));
                c.setDataVenda(rs.getDate("data_venda"));
                c.setTotal(rs.getInt("total"));

                Cliente obj = new Cliente();

                obj.setId(rs.getInt("id_cli"));

                c.setCliente(obj);

                listaVendas.add(c);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaVendas = null;
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

        return listaVendas;
    }

    public static List<Venda> buscarVendas(Date date, Date date0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

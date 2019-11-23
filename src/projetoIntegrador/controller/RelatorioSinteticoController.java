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
    
    private final VendaDAO vendaDAO = new VendaDAO();

    public List<Venda> consultarVendas(Date inicio, Date fim) {
        return vendaDAO.consultarVendas(inicio, fim);
    }
}

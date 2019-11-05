/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import projetoIntegrador.model.dao.VendaDAO;
import projetoIntegrador.model.entity.Venda;

/**
 *
 * @author Luciana Alves
 */
public class RelatorioSinteticoController {

    public static ArrayList<Venda> buscaPorPeriodo(Date inicio, Date fim) {
        ArrayList<Venda> vendas = new ArrayList<>();
        for (Venda v : VendaDAO.consultarVendas()) {

            if (v.getDataVenda().after(inicio) && v.getDataVenda().before(fim)) {
                vendas.add(v);
            }
        }
        return vendas;
    }

    public static List<Venda> buscarVendas(Date date, Date date0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.Date;
import java.util.List;
import projetoIntegrador.dao.VendaDAO;
import projetoIntegrador.model.Venda;
import projetoIntegrador.view.RelatorioSinteticoView;
import projetoIntegrador.view.VendaView;

/**
 *
 * Classe responsavel por gerar o relatório sintético
 * 
 * @author Luciana Alves
 */
public class RelatorioSinteticoController {

    private final VendaDAO vendaDAO = new VendaDAO();
    private final RelatorioSinteticoView relatorioSinteticoView;

    /**
     * 
     * Método para visualizar o relatório na view
     * 
     * @param relatorioSinteticoView 
     */
    public RelatorioSinteticoController(RelatorioSinteticoView relatorioSinteticoView) {
        this.relatorioSinteticoView = relatorioSinteticoView;
    }
    
    /**
     * 
     * Método para consultar as vendas em um periodo específico
     * 
     * @param inicio
     * @param fim
     * @return 
     */
    public List<Venda> consultarVendas(Date inicio, Date fim) {
        List<Venda> resultadoVenda = vendaDAO.consultarVendas(inicio, fim);
        double valor = 0;
        for (Venda venda : resultadoVenda) {
            valor = valor + venda.getTotal();
        }
        relatorioSinteticoView.atualizarTotalVenda(valor);
        return resultadoVenda;
    }
    
    
    
}

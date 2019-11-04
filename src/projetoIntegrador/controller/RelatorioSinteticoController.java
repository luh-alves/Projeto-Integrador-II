/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import projetoIntegrador.model.dao.VendaDAO;
import projetoIntegrador.model.entity.Venda;

/**
 *
 * @author Luciana Alves
 */
public class RelatorioSinteticoController {
    
    public static ArrayList<String []> buscaPorPeriodo(Date inicio, Date fim){
        ArrayList<String []> vendasString = new ArrayList<>();
          SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          for(Venda v: VendaDAO.consultarVendas()){
            
          if(v.getDataVenda().after(inicio) && v.getDataVenda().before(fim)){
          vendasString.add(new String[]{formato.format(v.getDataVenda()),v.getProdutos().get(0).getNome(),String.valueOf(v.getTotal())});
      }
      
       }
          return vendasString;
    }
}

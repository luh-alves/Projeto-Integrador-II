/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.dao;

import java.util.ArrayList;
import java.util.List;
import projetoIntegrador.model.Cliente;
import projetoIntegrador.model.Produto;
import projetoIntegrador.model.Venda;

/**
 *
 * @author Luciana Alves
 */
public class VendaDAO {

    public VendaDAO() {

    }

    public void salvarVenda(Venda venda) {
        SimulaBancoDados.getInstance().salvarVenda(venda);

        List<Produto> produtos = SimulaBancoDados.getInstance().consultarProduto();

        //tipo     nome     lista       
        for (Produto produto : venda.getProdutos()) {
            int index = produtos.indexOf(produto);
            Produto encontrado = produtos.get(index);
            encontrado.setQuantidade(encontrado.getQuantidade() - produto.getQuantidadeNaVenda());
        }
    }
    
     //aqui é busca uma arrayList do tipo Venda obtida do simulaBanco que manda para o controler passar para a view
       public static ArrayList<Venda> consultarVendas() {
        return SimulaBancoDados.getInstance().consultarVendas();
   }

}

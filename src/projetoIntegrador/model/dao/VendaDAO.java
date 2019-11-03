/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.dao;

import java.util.List;
import projetoIntegrador.model.entity.Produto;
import projetoIntegrador.model.entity.Venda;

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

}

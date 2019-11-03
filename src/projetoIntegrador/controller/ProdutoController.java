/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.ArrayList;
import java.util.List;
import projetoIntegrador.model.dao.ProdutoDAO;
import projetoIntegrador.model.entity.Produto;


public class ProdutoController {
    
        public static boolean salvar(String NomeProduto, int Quantidade, double Valor) {

        Produto p = new Produto(NomeProduto, Quantidade, Valor);
        return ProdutoDAO.salvarP(p);
    }

    public static boolean excluir(int pID) {

        return ProdutoDAO.excluirP(pID);

    }

    public static boolean atualizar(int pID, String NomeProduto, int Quantidade, Double Valor) {

        Produto p = new Produto(pID, NomeProduto, Quantidade, Valor);
        return ProdutoDAO.atualizarP(p);

    }

    public static ArrayList<String[]> getProdutos() {

        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {

            Produto ProdutoString = produtos.get(i);
            
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getId()), produtos.get(i).getNome(), String.valueOf(ProdutoString.getQuantidade()), String.valueOf(ProdutoString.getValor())});
        }
        return listaProdutos;
    } 
    
}

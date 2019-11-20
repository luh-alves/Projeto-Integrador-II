/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.ArrayList;
import java.util.List;
import projetoIntegrador.dao.ProdutoDAO;
import projetoIntegrador.model.Produto;
import projetoIntegrador.view.VendaView;

public class ProdutoController {

    ProdutoDAO produtoDao = new ProdutoDAO();

//    public static void salvarProduto(String nome, String quantidade, String valor) {
//        final Produto produto = new Produto();
//        produto.setNome(nome);
//        produto.setQuantidade(Integer.parseInt(quantidade));
//        produto.setValor(Double.parseDouble(valor));
//    }
    //daqui p baixo codigo wellington 
    public static boolean salvar(String NomeProduto, int Quantidade, double Valor) {

        Produto p = new Produto(NomeProduto, Quantidade, Valor);
        return ProdutoDAO.salvar(p);
    }

    public static boolean excluir(int pID) {

        return ProdutoDAO.excluir(pID);

    }

    public static boolean atualizar(int pID, String NomeProduto, int Quantidade, Double Valor) {

        Produto p = new Produto(pID, NomeProduto, Quantidade, Valor);
        return ProdutoDAO.atualizar(p);

    }

    public static ArrayList<String[]> getProdutos() {

        ArrayList<Produto> produtos = ProdutoDAO.consultarProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {

            Produto ProdutoString = produtos.get(i);

            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getId()), produtos.get(i).getNome(), String.valueOf(ProdutoString.getQuantidade()), String.valueOf(ProdutoString.getValor())});
        }
        return listaProdutos;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.ArrayList;
import projetoIntegrador.dao.ProdutoDAO;
import projetoIntegrador.model.Produto;
/**
 * Classe que representa a classe Produto Controler
 */

public class ProdutoController {

    ProdutoDAO produtoDao = new ProdutoDAO();

    /**
     * Salvar Produto
     * @param NomeProduto
     * @param Quantidade
     * @param Valor
     * @return 
     */
    public boolean salvar(String NomeProduto, int Quantidade, double Valor) {
        Produto p = new Produto(NomeProduto, Quantidade, Valor);
        return produtoDao.salvar(p);
    }

    /**
     * excluir produto
     * @param pID id do produto que deseja excluir
     * @return true caso seja possivel excluir o produto
     */
    public boolean excluir(int pID) {
        return produtoDao.excluir(pID);
    }

    /**
     * Atualizar produto
     * @param pID id do produto
     * @param NomeProduto
     * @param Quantidade
     * @param Valor
     * @return true caso seja possivel excluir e false caso de erro ao excluir
     */
    public boolean atualizar(int pID, String NomeProduto, int Quantidade, Double Valor) {
        Produto p = new Produto(pID, NomeProduto, Quantidade, Valor);
        return produtoDao.atualizar(p);
    }

    /**
     * Consultar produtos cadastrados
     * @return um ArrayList com todos os produtos cadastrados no banco de dados 
     */
    public ArrayList<String[]> getProdutos() {
        ArrayList<Produto> produtos = produtoDao.consultarProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (Produto ProdutoString : produtos) {
            listaProdutos.add(new String[]{String.valueOf(ProdutoString.getId()), ProdutoString.getNome(), String.valueOf(ProdutoString.getQuantidade()), String.valueOf(ProdutoString.getValor())});
        }
        return listaProdutos;
    }

}

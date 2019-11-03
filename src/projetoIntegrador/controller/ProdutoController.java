/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import projetoIntegrador.model.dao.ProdutoDAO;
import projetoIntegrador.model.entity.Produto;


public class ProdutoController {

    public static void salvarProduto(String nome, String quantidade, String valor) {
        final Produto produto = new Produto();
        produto.setNome(nome);
        produto.setQuantidade(Integer.parseInt(quantidade));
        produto.setValor(Double.parseDouble(valor));

    }
}

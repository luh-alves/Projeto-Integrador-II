/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.List;
import projetoIntegrador.model.dao.ProductDAO;
import projetoIntegrador.model.entity.Product;


public class ProdutosController {
    
    //private final ProductDAO produtosDAO = new ProductDAO();

    public static void salvarProduto(String nome, String quantidade, String valor) {
        final Product produto = new Product();
        produto.setNome(nome);
        produto.setQuantidade(Integer.parseInt(quantidade));
        produto.setValor(Double.parseDouble(valor));
        
        
        ProductDAO.salvarProduto(produto);
    }
    
    public static List<Product> getProducts(){
        return ProductDAO.listAllProducts();
    }
}

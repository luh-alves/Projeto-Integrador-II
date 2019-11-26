/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Classe que contem contrutores, getters e setters da venda
 *
 * @author Luciana Alves
 */
public class Venda {

    private int id;
    private Date dataVenda;
    private double total;
    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();

    /**
     *
     * Getter para pegar o ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * Setter para definir o ID
     *
     * @return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * Getter para pegar a data da venda
     *
     * @return
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     *
     * Setter para definir a data da venda
     *
     * @return
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     *
     * Getter para pegar o total da venda
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     *
     * Setter para defirnir o total da venda
     *
     * @return
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *
     * Getter para pegar o clienta para qual a venda foi realizada
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * Setter para definir o clienta para qual a venda foi realizada
     *
     * @return
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * Getter para pegar o produto que foi vendido
     *
     * @return
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     *
     * Setter para definir o produto que foi vendido
     *
     * @return
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;

    }

    
    /**
     * 
     * Método para atualizar a venda do produto
     * 
     * @param produto 
     */
    public void addProduto(Produto produto) {
        int index = produtos.indexOf(produto);
        if (index == -1) {//Produto ainda não está na lista, então adiciona.
            produtos.add(new Produto(produto));
        } else {//Já está na lista, só atualiza a quantidade
            Produto encontrado = produtos.get(index);
            int quantidadeAtual = encontrado.getQuantidadeNaVenda();
            int quantidadeAtualizada = quantidadeAtual + produto.getQuantidadeNaVenda();
            encontrado.setQuantidadeNaVenda(quantidadeAtualizada);
        }
        total = calculaTotal();
    }

    /**
     * 
     * Método para calcular o total da venda
     * 
     * @return 
     */
    private double calculaTotal() {
        double soma = 0;
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            soma = soma + (produto.getValor() * produto.getQuantidadeNaVenda());
        }
        return soma;
    }

    /**
     * 
     * Método para remover o produto após a venda
     * 
     * @param produto 
     */
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        total = calculaTotal();
    }

}

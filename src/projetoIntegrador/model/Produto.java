/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model;

import java.util.Objects;

/**
 *
 * Classe que contem construtor, getters e setters do produto
 *
 * @author wellington.eandrade
 */
public class Produto {

    //só para a aplicação
    private int quantidadeNaVenda;

    private int id;
    private String nome;
    private double valor;
    private int quantidade;

    public Produto() {
    }

    /**
     *
     * Contrutor usado para salvar produtos
     *
     * @param nome
     * @param qtd
     * @param valor
     */
    public Produto(String nome, int qtd, double valor) {
        this.nome = nome;
        this.quantidade = qtd;
        this.valor = valor;
    }

    /**
     *
     * Contrutor usado para atualizar produtos
     *
     * @param id
     * @param nome
     * @param qtd
     * @param valor
     */
    public Produto(int id, String nome, int qtd, double valor) {
        this.id = id;
        this.nome = nome;
        this.quantidade = qtd;
        this.valor = valor;
    }

    /**
     *
     * Contrutor usado para criar uma cópia dos dados salvos para a venda
     *
     * @param copia
     */
    public Produto(Produto copia) {
        this.id = copia.id;
        this.nome = copia.nome;
        this.valor = copia.valor;
        this.quantidade = copia.quantidade;
        this.quantidadeNaVenda = copia.quantidadeNaVenda;
    }

    /**
     *
     * Getter para pegar a quantidade na venda
     *
     * @return
     */
    public int getQuantidadeNaVenda() {
        return quantidadeNaVenda;
    }

    /**
     *
     * Setter para pegar a quantidade na venda
     *
     * @return
     */
    public void setQuantidadeNaVenda(int quantidadeNaVenda) {
        this.quantidadeNaVenda = quantidadeNaVenda;
    }

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
     * Setter para pegar o ID
     *
     * @return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * Getter para pegar o nome
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * Setter para pegar o nome
     *
     * @return
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * Getter para pegar o valor
     *
     * @return
     */
    public double getValor() {
        return valor;
    }

    /**
     *
     * Setter para pegar o valor
     *
     * @return
     */
    public void setValor(double valor) {
        if (valor < 0) {
            return;
        }
        this.valor = valor;
    }

    /**
     *
     * Getter para pegar a quantidade de produtos
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

        /**
     *
     * Setter para pegar a quantidade de produtos
     *
     * @return
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (Objects.equals(this.nome, other.nome)) {
            return true;
        }
        return false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.entity;

public class Produto {
    
    private static int qtdProdutosCriados;
    
    private int id;
    private String nome;
    private double valor;
    private int quantidade;
    
    public Produto() {

        qtdProdutosCriados++;
        this.id = qtdProdutosCriados;
    }

    public Produto(String NomeProduto, int Quantidade, Double valor){
        qtdProdutosCriados++;
        this.id = qtdProdutosCriados;
        this.nome = nome;
        this.quantidade = Quantidade;
        this.valor = valor;
    }
    
    public Produto(int id, String NomeProduto, int Quantidade, Double Valor){
        
        this.id = id;
        this.nome = NomeProduto;
        this.quantidade = Quantidade;
        this.valor = Valor;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            return;
        }
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

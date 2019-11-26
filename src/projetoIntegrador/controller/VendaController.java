/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.Date;
import java.util.List;
import projetoIntegrador.dao.ClienteDAO;
import projetoIntegrador.dao.ProdutoDAO;
import projetoIntegrador.dao.VendaDAO;
import projetoIntegrador.model.Cliente;
import projetoIntegrador.model.Produto;
import projetoIntegrador.model.Venda;
import projetoIntegrador.view.VendaView;

/**
 * Classe que representa a classe VendaCntroller
 * @author Luciana Alves
 */
public class VendaController {

    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final VendaDAO vendaDAO = new VendaDAO();
    private final VendaView vendaView;
    private Cliente clienteSelecionado;
    private Produto produtoSelecionado;
    private Venda venda = new Venda();
    private int quantidadeProduto;
    private double totalProdutoAtual;

    public VendaController(VendaView vendaView) {
        this.vendaView = vendaView;
    }
    
/**
 * adicionar produto na venda
 */
    public void adicionarProdutoNaVenda() {
        produtoSelecionado.setQuantidadeNaVenda(quantidadeProduto);
        venda.addProduto(produtoSelecionado);
        vendaView.atualizarListaDeProdutos(venda.getProdutos());
        vendaView.limparCamposProduto();
        vendaView.atualizarTotalVenda(venda.getTotal());

        produtoSelecionado = null;
    }
/**
 * Pesquisar Cliente
 * @param nome cliente que deseja pesquisar
 */
    public void pesquisarCliente(String nome) {

        if (nome.length() > 2) {
            List<Cliente> resultado = clienteDAO.pesquisarClientePorNome(nome);
            if (resultado.size() > 0) {
                vendaView.mostrarResultados(resultado);
            }

        }

    }

    /**
     * Selecionar o cliente
     * @param cliente recebe o cliente a ser selecionado
     */
    public void selecionarCliente(Cliente cliente) {
        this.clienteSelecionado = cliente;
        vendaView.atualizarCliente(cliente.getNome());
        this.venda.setCliente(cliente);
    }

    /**
     * Pesquisar produto por nome e mostrar o resultado
     * @param nome recebe o nome do produto a ser pesquisado 
     */
    public void pesquisarProduto(String nome) {
       if (nome.length() > 2) {
            List<Produto> resultadoProduto = produtoDAO.pesquisarProdutoPorNome(nome);
            if (resultadoProduto.size() > 0) {
                vendaView.mostrarResultadosProdutos(resultadoProduto);
            }

        }

    }

    /**
     * Selecionar produto
     * @param produto recebe o produto a ser selecionado
     */
    
    public void selecionarProduto(Produto produto) {
        this.produtoSelecionado = produto;
        vendaView.atualizarProduto(produto);
        vendaView.setQuantidadePadrão();
    }

    /**
     * adicionar a quatidade
     * @param text recebe a quantidade de produto que deseja comprar
     */
    public void adicionarQuantidade(String text) {
        int quantidadeDigitada;
        try {
            quantidadeDigitada = Integer.parseInt(text);
            if (quantidadeDigitada > produtoSelecionado.getQuantidade()) {
                vendaView.mostrarErro("Estoque Insuficiente");
                return;
            }
            quantidadeProduto = quantidadeDigitada;
            totalProdutoAtual = produtoSelecionado.getValor() * quantidadeProduto;
            vendaView.atualizarTotalProdutoAtual(totalProdutoAtual);
        } catch (Exception e) {
        }
    }

    /**
     * Salvar venda
     */
    public void salvarVenda() {
        venda.setDataVenda(new Date());
        vendaDAO.salvarVenda(venda);
    }

    /**
     * Verifica se foi selecionado um cliente
     * @return true caso tenha e false caso não tenha
     */
    public boolean temCliente() {
        return clienteSelecionado != null;
    }

    /**
     * Verifica se tem produto
     * @return true caso tenha e false caso não tenha
     */
    public boolean temProduto() {
        return venda.getProdutos().size() > 0;
    }

    /**
     * Verifica se foi selecionado um produto
     * @return true caso tenha e false caso não tenha
     */
    public boolean temProdutoSelecionado() {
        return produtoSelecionado != null;
    }

    /**
     * Excluir produto do carrinho
     * @param produtoSelecionado recebe o produdo que foi selecionado e deseja excluir
     */
    
    public void excluirProdutoDoCarrinho(Produto produtoSelecionado) {
        venda.removerProduto(produtoSelecionado);
        vendaView.atualizarListaDeProdutos(venda.getProdutos());
        vendaView.atualizarTotalVenda(venda.getTotal());

    }
    /**
     * Limpar venda
     */
    public void limparVenda(){
        venda = new Venda();
    }

}

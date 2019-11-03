/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.Date;
import java.util.List;
import projetoIntegrador.model.dao.ClienteDAO;
import projetoIntegrador.model.dao.ProdutoDAO;
import projetoIntegrador.model.dao.VendaDAO;
import projetoIntegrador.model.entity.Cliente;
import projetoIntegrador.model.entity.Produto;
import projetoIntegrador.model.entity.Venda;
import projetoIntegrador.view.VendaView;

/**
 *
 * @author Luciana Alves
 */
public class VendaController {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private VendaDAO vendaDAO = new VendaDAO();
    private VendaView vendaView;
    private Cliente clienteSelecionado;
    private Produto produtoSelecionado;
    private Venda venda = new Venda();
    private int quantidadeProduto;
    private double totalProdutoAtual;
    
    public VendaController(VendaView vendaView) {
        this.vendaView = vendaView;
    }
    
    public void adicionarProdutoNaVenda() {
        produtoSelecionado.setQuantidadeNaVenda(quantidadeProduto);
        venda.addProduto(produtoSelecionado);
        vendaView.atualizarListaDeProdutos(venda.getProdutos());
        vendaView.limparCamposProduto();
        vendaView.atualizarTotalVenda(venda.getTotal());
        
        produtoSelecionado = null;
    }
    
    public void pesquisarCliente(String nome) {
        
        if (nome.length() > 2) {
            List<Cliente> resultado = clienteDAO.pesquisarClientePorNome(nome);
            if (resultado.size() > 0) {
                vendaView.mostrarResultados(resultado);
            }
            
        }
        
    }
    
    public void selecionarCliente(Cliente cliente) {
        this.clienteSelecionado = cliente;
        vendaView.atualizarCliente(cliente.getNome());
        this.venda.setCliente(cliente);
    }
    
    public void pesquisarProduto(String nome) {
        if (nome.length() > 2) {
            List<Produto> resultadoProduto = produtoDAO.pesquisarProdutoPorNome(nome);
            if (resultadoProduto.size() > 0) {
                vendaView.mostrarResultadosProdutos(resultadoProduto);
            }
            
        }
        
    }
    
    public void selecionarProduto(Produto produto) {
        this.produtoSelecionado = produto;
        vendaView.atualizarProduto(produto);
        vendaView.setQuantidadePadrão();
    }
    
    public void adicionarQuantidade(String text) {
        try {
            quantidadeProduto = Integer.parseInt(text);
            if (quantidadeProduto > produtoSelecionado.getQuantidade()) {
                vendaView.mostrarErro("Estoque Insuficiente");
                return;
            }
            totalProdutoAtual = produtoSelecionado.getValor() * quantidadeProduto;
            vendaView.atualizarTotalProdutoAtual(totalProdutoAtual);
        } catch (Exception e) {
        }
    }
    
    public void salvarVenda() {
        venda.setDataVenda(new Date());
        vendaDAO.salvarVenda(venda);       
    }
    
    public boolean temCliente() {
        return clienteSelecionado != null;
    }
    
    public boolean temProduto() {
        return venda.getProdutos().size() > 0;
    }
    
    public boolean temProdutoSelecionado() {
        return produtoSelecionado != null;
    }
    
}

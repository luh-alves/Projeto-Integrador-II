/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.dao;

import java.util.ArrayList;
import projetoIntegrador.model.Cliente;
import projetoIntegrador.model.Produto;
import projetoIntegrador.model.Venda;

/**
 *
 * @author geovane.sarajo
 */
public class SimulaBancoDados {

    //Array para salvar os atributos do cliente
    public ArrayList<Cliente> linhasClienteTabela;
    public ArrayList<Produto> linhasProdutoTabela;
    public ArrayList<Venda> linhasVendaTabela;

    private SimulaBancoDados() {
        linhasClienteTabela = new ArrayList<Cliente>();
        linhasProdutoTabela = new ArrayList<Produto>();
        linhasVendaTabela = new ArrayList<Venda>();
    }

    private static SimulaBancoDados objBancoSimulado;

    //apenas um banco de dados na memoria
    //padrao: Singleton
    public static synchronized SimulaBancoDados getInstance() {
        if (objBancoSimulado == null) {
            objBancoSimulado = new SimulaBancoDados();
        }
        return objBancoSimulado;
    }

     public boolean salvarCliente(Cliente objCliente) {
        linhasClienteTabela.add(objCliente);
        return true;
    }
    
    public ArrayList<Cliente> consultarCliente() {
        return this.linhasClienteTabela;
    }

    //atulizar cliente aqui identifica o cliente pelo ID ao encontrar o cliente no for, seta os valores para o mesmo
    public boolean atualizarCliente(Cliente Cliente) {
        for (Cliente listarCliente : linhasClienteTabela) {
            if (listarCliente.getId()==(Cliente.getId())) {
                listarCliente.setNome(Cliente.getNome());
                listarCliente.setSexo(Cliente.getSexo());
                listarCliente.setDataNascimento(Cliente.getDataNascimento());
                listarCliente.setEstadoCivil(Cliente.getEstadoCivil());
                listarCliente.setEndereco(Cliente.getEndereco());
                listarCliente.setBairro(Cliente.getBairro());
                listarCliente.setCep(Cliente.getCep());
                listarCliente.setNumero(Cliente.getNumero());
                listarCliente.setCidade(Cliente.getCidade());
                listarCliente.setNacionalidade(Cliente.getNacionalidade());
                listarCliente.setEmail(Cliente.getEmail());
                listarCliente.setTelefone(Cliente.getTelefone());
                listarCliente.setTelefone2(Cliente.getTelefone2());
                listarCliente.setUltimaAtualizacao(Cliente.getUltimaAtualizacao());
            }
        }
        return true;
    }
    
    public boolean excluirCliente(int id) {
        
        boolean clienteExiste = false;
        for (Cliente c : linhasClienteTabela) {
            Cliente clienteExcluir = null;
            if (c.getId()==id) {
                clienteExcluir = c;
                clienteExiste = true;
            }
            if (clienteExiste) {
                linhasClienteTabela.remove(clienteExcluir);
                break; //sem o break O clinete é excluído porém no console da erro e não carrega a tabela nem aperece a msg: cliente excluido
            }
            
        }
        return true;
    }

    public boolean salvarProduto(Produto objProduto) {
        linhasProdutoTabela.add(objProduto);
        return true;
    }

    public ArrayList<Produto> consultarProduto() {
        return this.linhasProdutoTabela;
    }

    //atulizar Produto aqui identifica o cliente pelo cpf ao encontrar o cliente no for, seta os valores para o mesmo
    public boolean atualizarProduto(Produto produto) {
        for (Produto listarProduto : linhasProdutoTabela) {
            if (listarProduto.getId() == produto.getId()) {
                listarProduto.setNome(produto.getNome());
                listarProduto.setValor(produto.getValor());
                listarProduto.setQuantidade(produto.getQuantidade());
            }

        }
        return true;
    }

    public boolean excluirProduto(int id) {
        boolean produtoExiste = false;
        for (Produto p : linhasProdutoTabela) {
            Produto produtoExcluir = null;
            if (p.getId() == id) {
                produtoExcluir = p;
                produtoExiste = true;
            }
            if (produtoExiste) {
                linhasProdutoTabela.remove(produtoExcluir);
                break; //sem o break O produto é excluído porém no console da erro e não carrega a tabela nem aperece a msg: produto excluido
            }
        }
        return true;
    }
    
    //vendas
    
    public boolean salvarVenda(Venda objVenda) {
        linhasVendaTabela.add(objVenda);
        return true;
    }
    
     public ArrayList<Venda> consultarVendas() {
        return this.linhasVendaTabela;
    }
     
      //atulizar Produto aqui identifica o cliente pelo cpf ao encontrar o cliente no for, seta os valores para o mesmo
    public boolean atualizarVenda(Venda venda) {
        for (Venda listarVenda : linhasVendaTabela) {
            if (listarVenda.getId() == venda.getId()) {
                listarVenda.setDataVenda(venda.getDataVenda());
                listarVenda.setTotal(venda.getTotal());
                listarVenda.setCliente(venda.getCliente());
                listarVenda.setProdutos(venda.getProdutos());
            }
        }
        return true;
    }

    public boolean excluirVenda(int id) {
        boolean vendaExiste = false;
        for (Venda v : linhasVendaTabela) {
            Venda vendaProduto = null;
            if (v.getId() == id) {
                vendaProduto = v;
                vendaExiste = true;
            }
            if (vendaExiste) {
                linhasVendaTabela.remove(vendaProduto);
                break; //sem o break a venda é excluída porém no console da erro e não carrega a tabela nem aperece a msg: venda excluida
            }
        }
        return true;
    }
}
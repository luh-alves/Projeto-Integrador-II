/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.List;
import projetoIntegrador.model.dao.ClienteDAO;
import projetoIntegrador.model.entity.Cliente;
import projetoIntegrador.view.VendaView;

/**
 *
 * @author Luciana Alves
 */
public class VendaController {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private VendaView vendaView;
    private Cliente clienteSelecionado;

    public VendaController(VendaView vendaView) {
        this.vendaView = vendaView;
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

    }

}

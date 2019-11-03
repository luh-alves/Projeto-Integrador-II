/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Luciana Alves
 */
public class Venda {

    private int id;
    private Date dataVenda;
    private double total;
    private Cliente cliente;
    private List<Produto> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return products;
    }

    public void setProdutos(List<Produto> products) {
        this.products = products;
    }

}

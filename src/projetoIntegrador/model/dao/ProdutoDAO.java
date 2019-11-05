/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.dao;

import java.util.ArrayList;
import java.util.List;
import projetoIntegrador.model.entity.Produto;

public class ProdutoDAO {

    private static final String TABLE_NAME = "produto";
    private static Object statement;

    public List<Produto> pesquisarProdutoPorNome(String name) {

        List<Produto> resultadoP = new ArrayList<>();
        for (Produto produto : SimulaBancoDados.getInstance().consultarProduto()) {
            if (produto.getNome().toLowerCase().contains(name.toLowerCase())) {
                resultadoP.add(produto);
            }
        }
        return resultadoP;
    }
    //daqui p baixo codigo wellington
    public static boolean salvarP(Produto p) {

        return SimulaBancoDados.getInstance().salvarProduto(p);
    }

    public static boolean atualizarP(Produto p) {

        return SimulaBancoDados.getInstance().atualizarProduto(p);
    }

    public static boolean excluirP(int pID) {

        return SimulaBancoDados.getInstance().excluirProduto(pID);

    }

    public static ArrayList<Produto> getProdutos() {

        return SimulaBancoDados.getInstance().consultarProduto();

    }

}

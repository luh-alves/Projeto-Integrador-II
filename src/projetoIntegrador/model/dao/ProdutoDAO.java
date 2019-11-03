/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetoIntegrador.model.database.Database;
import projetoIntegrador.model.entity.Produto;

public class ProdutoDAO {

        public static boolean salvarP(Produto p){
        
        return SimulaBancoDados.getInstance().salvarProduto(p);
    }
    
    public static boolean atualizarP(Produto p){
        
        return SimulaBancoDados.getInstance().atualizarProduto(p);
    }
    
    public static boolean excluirP(int pID){
        
        return SimulaBancoDados.getInstance().excluirProduto(pID);
        
    }
    
    public static ArrayList<Produto> getProdutos(){
        
        return SimulaBancoDados.getInstance().consultarProduto();
        
    }
    
    }


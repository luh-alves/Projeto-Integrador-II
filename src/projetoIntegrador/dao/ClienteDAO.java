/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.dao;

import java.util.ArrayList;
import java.util.List;
import projetoIntegrador.dao.SimulaBancoDados;
import projetoIntegrador.model.Cliente;

/**
 *
 * @author geovane.saraujo
 */
public class ClienteDAO {
    
    //Salvar cliente no banco de dados simulado, apenas o objeto e se for "salvo corretamento" retorna como true nesse banco sempre i´ra retorna como true
     public static boolean salvarCliente(Cliente objCliente) {
        //simular uma inserção no bando de dados
        return SimulaBancoDados.getInstance().salvarCliente(objCliente);
    }
     
     //aqui busca uma arrayList do tipo Cliente do simulaBanco e manda para o controler passar para a view
       public static ArrayList<Cliente> ConsultarClientes() {
        return SimulaBancoDados.getInstance().consultarCliente();
   }
       
       //atulliza o cliente enviando o objeto para o simula banco
        public static boolean atualizarCliente(Cliente objCliente) {
        return SimulaBancoDados.getInstance().atualizarCliente(objCliente);
  }
        //exclui o cliente passando o cpf(codigo de identificação) para o bancoSimulado procurar e excluir o cliente desejado 
     public static boolean excluirCliente(int id) {
       return SimulaBancoDados.getInstance().excluirCliente(id);
     }

    public List<Cliente> pesquisarClientePorNome(String name) {

        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : SimulaBancoDados.getInstance().consultarCliente()) {
            if (cliente.getNome().toLowerCase().contains(name.toLowerCase())) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }
}

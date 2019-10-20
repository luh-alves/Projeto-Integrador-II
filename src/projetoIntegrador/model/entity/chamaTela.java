/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.entity;

import java.util.Locale;
import projetoIntegrador.view.ClientesView;

/**
 *
 * @author fabiana.vsilva6
 */
public class chamaTela {
    
    
    public static void telaCliente(){
    ClientesView telaCliente = new ClientesView();
     telaCliente.setContentPane(telaCliente);
       telaCliente.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.view;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import projetoIntegrador.controller.ClienteController;
import static projetoIntegrador.dao.ClienteDAO.ConsultarClientes;
import projetoIntegrador.model.Cliente;
/**
 *
 * @author Avell B154 PLUS
 */
public class testeDatas {
    public static void main(String[] args) {
       Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        for(int i =1;i<100;i++){
        ClienteController.salvarCliente("111111", "nome " + i, 0, date, 0, "endereco", "bairro", "cep", "numero", "cidade", "nacionalidade", "email", "telefone", "telefone2", new GregorianCalendar(2019,7, i).getTime(), date);        
        }
     Date date1 = new GregorianCalendar(2019,8, 0).getTime();
     Date date2 = new GregorianCalendar(2019,8, 11).getTime();
      for(Cliente c: ConsultarClientes()){
          if(c.getDataCadastro().after(date1) && c.getDataCadastro().before(date2)){
          System.out.println(formato.format(c.getDataCadastro())+" "+c.getNome());
      }
      
       }
    }
}

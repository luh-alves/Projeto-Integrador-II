/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.controller;

import java.util.List;
import projetoIntegrador.model.dao.CustomerDAO;
import projetoIntegrador.model.entity.Customer;

/**
 *
 * @author Luciana Alves
 */
public class CustomerController {
    private CustomerDAO customerDAO = new CustomerDAO();

    public void searchCustomer(String nome) {  
        
         List<Customer> cust = customerDAO.findCustomerByName(nome);
         System.out.println(cust);

    }

}

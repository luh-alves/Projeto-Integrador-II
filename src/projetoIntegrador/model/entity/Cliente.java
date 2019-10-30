/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model.entity;

import java.util.Date;

/**
 *
 * @author Luciana Alves
 */
public class Cliente {
    private static int qtdClientes;
    
    private int id;
    private String cpf;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String estadoCivil;
    private String endereco;
    private String email;
    private String telefone;
    
    public Cliente(){
        qtdClientes++;
        this.id = qtdClientes;
    }
    
    public Cliente(int id, String cpf, String nome,String sexo, Date dataNascimento,String estadoCivil,String endereco, String email, String telefone){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    
    
    public Cliente(String cpf, String nome,String sexo, Date dataNascimento,String estadoCivil,String endereco, String email, String telefone){
        qtdClientes++;
        this.id = qtdClientes;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}

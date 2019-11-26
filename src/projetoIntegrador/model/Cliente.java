/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoIntegrador.model;

import java.util.Date;

/**
 *
 * @author geovane.saraujo
 */
public class Cliente {

    //atributos
    private int id;
    private String cpf;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String estadoCivil;
    private String endereco;
    private String bairro;
    private String cep;
    private String numero;
    private String cidade;
    private String nacionalidade;
    private String email;
    private String telefone;
    private String telefone2;
    private Date dataCadastro;
    private Date ultimaAtualizacao;

    
    public Cliente() {
    }
    /**
     * Cadastrar novo Cliente
     * @param cpf
     * @param nome
     * @param sexo
     * @param dataNascimento
     * @param estadoCivil
     * @param endereco
     * @param bairro
     * @param cep
     * @param numero
     * @param cidade
     * @param nacionalidade
     * @param email
     * @param telefone
     * @param telefone2
     * @param dataCadastro
     * @param ultimaAtualizacao 
     */
    public Cliente(String cpf, String nome, String sexo, Date dataNascimento, 
            String estadoCivil, String endereco, String bairro, String cep,
            String numero, String cidade, String nacionalidade, String email,
            String telefone, String telefone2, Date dataCadastro,
            Date ultimaAtualizacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.dataCadastro = dataCadastro;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    //Contrutor de atualizar o cliente 
    /**
     * Atualizado dados de um cliente cadastrado
     * @param id
     * @param cpf
     * @param nome
     * @param sexo
     * @param dataNascimento
     * @param estadoCivil
     * @param endereco
     * @param bairro
     * @param cep
     * @param numero
     * @param cidade
     * @param nacionalidade
     * @param email
     * @param telefone
     * @param telefone2
     * @param ultimaAtualizacao 
     */
    public Cliente(int id,String cpf, String nome, String sexo, Date dataNascimento,
            String estadoCivil, String endereco, String bairro, String cep,
            String numero, String cidade, String nacionalidade, String email,
            String telefone, String telefone2, Date ultimaAtualizacao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    // abaixo os getters e setters dos atributos Clientes
    /**
     * pegar o id do cliente
     * @return id do cliente
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Pegar o cpf do cliente
     * @return cpf do cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * alternar o cpf 
     * @param cpf 
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /**
     * pegar o nome do cliente
     * @return o nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * alterar nome cliente
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @return o sexo do cliente 
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Alterar o sexo do cliente
     * @param sexo 
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    /**
     * pegar data de nascimento
     * @return data de nascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * alterar data de Nascimento
     * @param dataNascimento 
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Pegar o estado civil do cliente
     * @return o estado civil do cliente
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * alterar o estado civil do cliente
     * @param estadoCivil 
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
     
    /**
     * 
     * @return o enderenço do cliente 
     */
    public String getEndereco() {
        return endereco;
    }
    
     /**
      * alterar o endereço
      * @param endereco 
      */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    /**
     * pegar o bairro do cliente
     * @return o bairro do cliente
     */
    public String getBairro() {
        return bairro;
    }
    
    /**
     * alterar o bairro
     * @param bairro 
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    /**
     * pegar o CEP
     * @return cep do cliente
     */
    public String getCep() {
        return cep;
    }

      /**
       * Alterar o cep do cliente
       * @param cep 
       */
    public void setCep(String cep) {
        this.cep = cep;
    }
    /**
     * pegar o numero da casa do cliente
     * @return o numero do cliente
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * Alterar o nomero do cliente
     * @param numero 
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    /**
     * pegar a cidade do cliente
     * @return cidade
     */
    public String getCidade() {
        return cidade;
    }
    
    /**
     * alterar a cidade do cliente
     * @param cidade 
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    /**
     * pegar a  nacionalidade do cliente
     * @return nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }
    
    /**
     * alterar nacionalidade
     * @param nacionalidade 
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * pegar o email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * alterar o email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
/**
 * pegar telefone
 * @return 
 */
    public String getTelefone() {
        return telefone;
    } 
 
    /**
     * alterar o telefone
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    } 
    
    /**
     * pegar o telefone 2
     * @return telefone2
     */
    public String getTelefone2() {
        return telefone2;
    }

    /**
     * alterar o telefone 2
     * @param telefone2 
     */
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
    
    /**
     * pegar data de cadastro
     * @return dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }
    
    /**
     * alterar data Cadastro
     * @param dataCadastro 
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * pegar data da ultima atualização
     * @return ultimaAtualizacao
     */
    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }
    
    /**
     * alterar data ultima Atualizacao
     * @param ultimaAtualizacao 
     */
    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

}

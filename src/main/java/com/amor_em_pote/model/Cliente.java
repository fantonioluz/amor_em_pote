package com.amor_em_pote.model;

public class Cliente {
    private Integer codCliente;
    private String telefone;
    private String nomeCliente;
    private String numero;
    private String rua;
    private String bairro;

    public Cliente() {}

    public Cliente(int codCliente, String telefone, String nomeCliente, String numero, String rua, String bairro) {
        this.codCliente = codCliente;
        this.telefone = telefone;
        this.nomeCliente = nomeCliente;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
    }

    // Getters e Setters

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}

package com.amor_em_pote.model;

public class Fornecedor {

    private int cod_fornecedor;
    private String nome_fornecedor;

    public Fornecedor() {}

    public Fornecedor(int cod_fornecedor, String nome_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
        this.nome_fornecedor = nome_fornecedor;
    }
    public int getCod_fornecedor() {
        return cod_fornecedor;
    }
    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }
    public String getNome_fornecedor() {
        return nome_fornecedor;
    }
    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }
}

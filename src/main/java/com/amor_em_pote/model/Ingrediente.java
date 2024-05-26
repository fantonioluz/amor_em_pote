package com.amor_em_pote.model;

public class Ingrediente {

    private int cod_ingrediente;
    private String nome_ingrediente;
    private String descricao;
    private float valor;
    private int quantidade;

    public Ingrediente() {}

    public Ingrediente(int cod_ingrediente, String nome_ingrediente, String descricao, int valor) {
        this.cod_ingrediente = cod_ingrediente;
        this.nome_ingrediente = nome_ingrediente;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = 0;

    }

    public int getCod_ingrediente() {
        return cod_ingrediente;
    }

    public void setCod_ingrediente(int cod_ingrediente) {
        this.cod_ingrediente = cod_ingrediente;
    }

    public String getNome_ingrediente() {
        return nome_ingrediente;
    }

    public void setNome_ingrediente(String nome_ingrediente) {
        this.nome_ingrediente = nome_ingrediente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}


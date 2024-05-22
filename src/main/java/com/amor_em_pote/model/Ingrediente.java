package com.amor_em_pote.model;

public class Ingrediente {

    private int cod_ingrediente;
    private String nome_ingrediente;
    private String descricao;
    private int valor;

    public Ingrediente() {}

    public Ingrediente(int cod_ingrediente, String nome_ingrediente, String descricao, int valor) {
        this.cod_ingrediente = cod_ingrediente;
        this.nome_ingrediente = nome_ingrediente;
        this.descricao = descricao;
        this.valor = valor;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (valor > 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("Valor must be greater than 0");
        }
    }
}


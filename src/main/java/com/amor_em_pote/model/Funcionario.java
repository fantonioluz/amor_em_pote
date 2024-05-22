package com.amor_em_pote.model;

import java.util.Objects;

public class Funcionario {

    private String cod_funcionario;
    private int salario;
    private String expediente;
    private String nome;

    public Funcionario() {}

    public Funcionario(String cod_funcionario, int salario, String expediente, String nome) {
        this.cod_funcionario = cod_funcionario;
        this.salario = salario;
        this.expediente = expediente;
        this.nome = nome;
    }

    public String getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(String cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        if (salario > 0) {
            this.salario = salario;
        } else {
            throw new IllegalArgumentException("Salario must be greater than 0");
        }
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


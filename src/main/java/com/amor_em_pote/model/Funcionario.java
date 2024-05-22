package com.amor_em_pote.model;

public class Funcionario {

    private int cod_funcionario;
    private int salario;
    private char expediente;
    private String nome;

    public Funcionario() {}

    public Funcionario(int cod_funcionario, int salario, char expediente, String nome) {
        this.cod_funcionario = cod_funcionario;
        this.salario = salario;
        this.expediente = expediente;
        this.nome = nome;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
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

    public char getExpediente() {
        return expediente;
    }

    public void setExpediente(char expediente) {
        if (expediente == 'M' || expediente == 'T' || expediente == 'N') {
            this.expediente = expediente;
        } else {
            throw new IllegalArgumentException("Expediente must be 'M', 'T', or 'N'");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


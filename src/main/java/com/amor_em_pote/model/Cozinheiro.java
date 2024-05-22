package com.amor_em_pote.model;

public class Cozinheiro extends Funcionario {

    private int experiencia;

    public Cozinheiro() {
        super();
    }

    public Cozinheiro(int cod_funcionario, int salario, char expediente, String nome, int experiencia) {
        super(cod_funcionario, salario, expediente, nome);
        this.experiencia = experiencia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        if (experiencia >= 0) {
            this.experiencia = experiencia;
        } else {
            throw new IllegalArgumentException("Experiencia must be non-negative");
        }
    }
}


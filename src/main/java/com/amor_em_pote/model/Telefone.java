package com.amor_em_pote.model;

public class Telefone {
    private int telefonePK;
    private String telefone;
    private String fkClienteCpf;

    // Getters e setters
    public int getTelefonePK() {
        return telefonePK;
    }

    public void setTelefonePK(int telefonePK) {
        this.telefonePK = telefonePK;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFkClienteCpf() {
        return fkClienteCpf;
    }

    public void setFkClienteCpf(String fkClienteCpf) {
        this.fkClienteCpf = fkClienteCpf;
    }
}

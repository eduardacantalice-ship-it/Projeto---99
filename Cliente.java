package com.app99.model;

public class Cliente extends Usuario {
    private String enderecoPadrao;

    public Cliente(String id, String nome, String email, String telefone, String enderecoPadrao) {
        super(id, nome, email, telefone);
        this.enderecoPadrao = enderecoPadrao;
    }

    public String getEnderecoPadrao() {
        return enderecoPadrao;
    }

    public void setEnderecoPadrao(String enderecoPadrao) {
        this.enderecoPadrao = enderecoPadrao;
    }
}
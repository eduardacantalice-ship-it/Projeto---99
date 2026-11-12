package com.app99.model;

import com.app99.interfaces.Atendivel;

public class Entregador extends Usuario implements Atendivel {
    private String tipoVeiculo; // Ex: Moto, Bicicleta, Carro
    private boolean disponivel;

    public Entregador(String id, String nome, String email, String telefone, String tipoVeiculo) {
        super(id, nome, email, telefone);
        this.tipoVeiculo = tipoVeiculo;
        this.disponivel = true;
    }

    @Override
    public boolean aceitarSolicitacao(String idSolicitacao) {
        if (disponivel) {
            this.disponivel = false;
            System.out.println("Entregador " + getNome() + " aceitou a entrega " + idSolicitacao);
            return true;
        }
        return false;
    }

    @Override
    public boolean concluirAtendimento(String idSolicitacao) {
        this.disponivel = true;
        System.out.println("Entregador " + getNome() + " concluiu a entrega " + idSolicitacao);
        return true;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
package com.app99.model;

import com.app99.enums.StatusServico;
import com.app99.interfaces.Atendivel;

public class Motorista extends Usuario implements Atendivel {
    private String cnh;
    private String placaVeiculo;
    private String modeloVeiculo;

    public Motorista(String id, String nome, String email, String senha, String cnh, String placaVeiculo,
            String modeloVeiculo) {
        super(id, nome, email, senha);
        this.cnh = cnh;
        this.placaVeiculo = placaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
    }

    @Override
    public String getPerfil() {
        return "Motorista";
    }

    public boolean aceitarCorrida(Corrida corrida) {
        corrida.atribuirMotorista(this);
        corrida.atualizarStatus(StatusServico.ACEITO);
        return true;
    }

    public void atualizarStatus(Corrida corrida, StatusServico novoStatus) {
        corrida.atualizarStatus(novoStatus);
    }

    @Override
    public boolean aceitarAtendimento() {
        return true;
    }

    @Override
    public void atualizarStatusAtendimento(StatusServico novoStatus) {
        System.out.println("Status da corrida atualizado para: " + novoStatus);
    }

    @Override
    public void finalizarAtendimento() {
        System.out.println("Corrida finalizada pelo motorista.");
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }
}
package com.app99.interfaces;

public interface Atendivel {
    boolean aceitarSolicitacao(String idSolicitacao);
    boolean concluirAtendimento(String idSolicitacao);
}
package com.app99.model;

public class Avaliacao {
    private String id;
    private Servico servico;
    private Usuario avaliador;
    private int nota; // Ex: 1 a 5
    private String comentario;

    public Avaliacao(String id, Servico servico, Usuario avaliador, int nota, String comentario) {
        this.id = id;
        this.servico = servico;
        this.avaliador = avaliador;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Usuario avaliador) {
        this.avaliador = avaliador;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
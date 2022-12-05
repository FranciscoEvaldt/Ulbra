package com.example.hellowolrd;

public class saudacao {
    private final long id;
    private final String conteudo;

    public saudacao(Long id, String conteudo){
        this.id = id;
        this.conteudo = conteudo;
    }

    public long getId(){
        return id;
    }
    public String getConteudo(){
        return conteudo;
    }
}

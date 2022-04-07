package com.zupedu.bancodigital.conta;

public class ContaIdInexistenteException extends RuntimeException{

    public ContaIdInexistenteException() {
        super("Não existe conta com esse ID");
    }
}

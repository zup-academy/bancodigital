package com.zupedu.bancodigital.conta;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ContaRequest {

    @CPF
    @NotBlank
    @NotNull
    private String documentoTitular;

    @NotNull
    private String nomeTitular;

    private int agencia;

    private long numero;

    private BigDecimal saldo;

    public void setDocumentoTitular(String documentoTitular) {
        this.documentoTitular = documentoTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Conta toModel() {
        return new Conta(this.documentoTitular, this.nomeTitular,
                this.agencia, this.numero, this.saldo);
    }
}

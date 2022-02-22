package com.zupedu.bancodigital.conta;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContaRequest {

    @NotBlank
    private String documentoTitular;

    @NotBlank
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

    public Conta getConta() {
        return new Conta(this.documentoTitular, this.nomeTitular,
                this.agencia, this.numero, this.saldo);
    }
}

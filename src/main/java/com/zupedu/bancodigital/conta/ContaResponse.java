package com.zupedu.bancodigital.conta;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContaResponse {

    private Long id;

    private String documentoTitular;

    private String nomeTitular;

    private int agencia;

    private long numero;

    private BigDecimal saldo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;

    public ContaResponse(Long id, String documentoTitular, String nomeTitular,
                         int agencia, long numero, BigDecimal saldo,
                         LocalDateTime dataCriacao) {
        this.id = id;
        this.documentoTitular = documentoTitular;
        this.nomeTitular = nomeTitular;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataCriacao = dataCriacao;
    }

    public static ContaResponse from(Conta conta) {
        return new ContaResponse(conta.getId(), conta.getDocumentoTitular(),
                conta.getNomeTitular(), conta.getAgencia(), conta.getNumero(),
                conta.getSaldo(), conta.getDataCriacao());
    }

    public Long getId() {
        return id;
    }

    public String getDocumentoTitular() {
        return documentoTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public int getAgencia() {
        return agencia;
    }

    public long getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public static ContaResponse of(Conta conta){
        return new ContaResponse(conta.getId(), conta.getDocumentoTitular(),
                conta.getNomeTitular(), conta.getAgencia(),
                conta.getNumero(), conta.getSaldo(), conta.getDataCriacao());
    }
}

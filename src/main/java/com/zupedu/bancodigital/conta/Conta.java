package com.zupedu.bancodigital.conta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentoTitular;

    private String nomeTitular;

    private int agencia;

    private long numero;

    private BigDecimal saldo;

    private LocalDateTime dataCriacao;

    @Deprecated
    public Conta() {
    }

    public Conta(String documentoTitular, String nomeTitular,
                 int agencia,long numero, BigDecimal saldo) {
        this.documentoTitular = documentoTitular;
        this.nomeTitular = nomeTitular;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataCriacao = LocalDateTime.now();
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
}

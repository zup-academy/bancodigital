package com.zupedu.bancodigital.transferencia;

import com.zupedu.bancodigital.conta.Conta;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @ManyToOne
    private Conta contaOrigem;

    @ManyToOne
    private Conta contaDestino;

    private LocalDateTime realizadoEm;

    @Deprecated
    public Transferencia() {
    }

    public Transferencia(BigDecimal valor, Conta contaOrigem, Conta contaDestino) {
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.realizadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public LocalDateTime getRealizadoEm() {
        return realizadoEm;
    }
}

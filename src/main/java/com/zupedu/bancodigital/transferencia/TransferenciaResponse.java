package com.zupedu.bancodigital.transferencia;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferenciaResponse {

    private Long id;

    private BigDecimal valor;

    private TransferenciaContaDto contaOrigem;

    private TransferenciaContaDto contaDestino;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime realizadoEm;

    public TransferenciaResponse() {
    }

    private TransferenciaResponse(Long id, BigDecimal valor,
                                  TransferenciaContaDto contaOrigem,
                                  TransferenciaContaDto contaDestino,
                                  LocalDateTime realizadoEm) {
        this.id = id;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.realizadoEm = realizadoEm;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransferenciaContaDto getContaOrigem() {
        return contaOrigem;
    }

    public TransferenciaContaDto getContaDestino() {
        return contaDestino;
    }

    public LocalDateTime getRealizadoEm() {
        return realizadoEm;
    }

    public static TransferenciaResponse from(Transferencia transferencia){
        var contaDestino = new TransferenciaContaDto(
                transferencia.getContaDestino().getAgencia(),
                transferencia.getContaDestino().getNumero());

        var contaOrigem = new TransferenciaContaDto(
                transferencia.getContaOrigem().getAgencia(),
                transferencia.getContaOrigem().getNumero());

        return new TransferenciaResponse(transferencia.getId(),transferencia.getValor(),
                contaOrigem, contaDestino, transferencia.getRealizadoEm());

    }
}

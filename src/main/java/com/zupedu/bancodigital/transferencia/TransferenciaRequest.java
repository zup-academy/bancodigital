package com.zupedu.bancodigital.transferencia;

import com.zupedu.bancodigital.conta.ContaRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransferenciaRequest {

    @Positive
    private BigDecimal valor;

    @NotNull
    private TransferenciaContaDto contaOrigem;

    @NotNull
    private TransferenciaContaDto contaDestino;


    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setContaOrigem(TransferenciaContaDto contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void setContaDestino(TransferenciaContaDto contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Transferencia toModel(ContaRepository contaRepository) {

        var contaDestino = contaRepository.findByAgenciaAndNumero(
                        this.contaDestino.getAgencia(), this.contaDestino.getNumero())
                .orElseThrow(ContaAgenciaNumeroInexistente::new);

        var contaOrigem = contaRepository.findByAgenciaAndNumero(
                        this.contaOrigem.getAgencia(), this.contaOrigem.getNumero())
                .orElseThrow(ContaAgenciaNumeroInexistente::new);

        return new Transferencia(this.valor, contaDestino, contaOrigem);
    }
}

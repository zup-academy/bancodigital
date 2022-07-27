package com.zupedu.bancodigital.pagamento;

import java.math.BigDecimal;

public class PagamentoRealizado {

    private Long codigoPagamento;

    private BigDecimal valor;

    private long numeroConta;

    private int agenciaConta;

    private String origem;

    private TipoPagamentoEnum tipoPagamento;


    public PagamentoRealizado(Long codigoPagamento, BigDecimal valor,
                              long numeroConta, int agenciaConta,
                              String origem, TipoPagamentoEnum tipoPagamento) {
        this.codigoPagamento = codigoPagamento;
        this.valor = valor;
        this.numeroConta = numeroConta;
        this.agenciaConta = agenciaConta;
        this.origem = origem;
        this.tipoPagamento = tipoPagamento;
    }

    public Long getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(Long codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(int agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "PagamentoRealizado{" +
                "codigoPagamento=" + codigoPagamento +
                ", valor=" + valor +
                ", numeroConta=" + numeroConta +
                ", agenciaConta=" + agenciaConta +
                ", origem='" + origem + '\'' +
                ", tipoPagamento=" + tipoPagamento +
                '}';
    }
}
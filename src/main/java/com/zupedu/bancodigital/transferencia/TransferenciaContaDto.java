package com.zupedu.bancodigital.transferencia;

public class TransferenciaContaDto {

    private int agencia;

    private long numero;

    public TransferenciaContaDto(int agencia, long numero) {
        this.agencia = agencia;
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
}

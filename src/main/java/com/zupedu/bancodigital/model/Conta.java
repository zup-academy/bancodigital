package com.zupedu.bancodigital.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    @NotNull
    private Tipo tipo;

    @NotNull
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne
    @NotNull
    private Correntista correntista;

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public Conta() { }

    public Conta(Tipo tipo, Correntista correntista) {
        this.tipo = tipo;
        this.correntista = correntista;
    }

    public void deposita(BigDecimal valor) {
        this.saldo = saldo.add(valor);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return tipo == conta.tipo && Objects.equals(correntista, conta.correntista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, correntista);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Conta.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("tipo=" + tipo)
                .add("saldo=" + saldo)
                .add("correntista=" + correntista)
                .toString();
    }
}

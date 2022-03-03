package com.zupedu.bancodigital.conta;

import com.zupedu.bancodigital.produto.Produto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "conta_produto", joinColumns=
            {@JoinColumn(name="id_conta")}, inverseJoinColumns=
            {@JoinColumn(name="id_produto")})
    private List<Produto> produtos;

    @Deprecated
    public Conta() {
    }

    public Conta(String documentoTitular, String nomeTitular,
                 int agencia,long numero, BigDecimal saldo,
                 List<Produto> produtos) {
        this.documentoTitular = documentoTitular;
        this.nomeTitular = nomeTitular;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataCriacao = LocalDateTime.now();
        this.produtos = produtos;
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

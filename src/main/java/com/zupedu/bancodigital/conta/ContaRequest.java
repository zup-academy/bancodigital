package com.zupedu.bancodigital.conta;

import com.zupedu.bancodigital.produto.ProdutoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ContaRequest {

    @NotBlank
    private String documentoTitular;

    @NotBlank
    private String nomeTitular;

    private int agencia;

    private long numero;

    private BigDecimal saldo;

    @NotEmpty
    private List<Long> produtos;

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

    public Conta getConta(ProdutoRepository produtoRepository) {
        var produtos = this.produtos.stream()
                .map(id -> produtoRepository.getById(id))
                .collect(Collectors.toList());

        return new Conta(this.documentoTitular, this.nomeTitular,
                this.agencia, this.numero, this.saldo, produtos);
    }
}

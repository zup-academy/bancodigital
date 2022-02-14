package com.zupedu.bancodigital.conta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContaEntity {

    private Long id;

    private String documentoTitular;

    private String nomeTitular;

    private LocalDateTime abertura;

    private int agencia;

    private long numero;

    private BigDecimal saldo;

}

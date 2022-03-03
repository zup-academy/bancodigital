package com.zupedu.bancodigital.produto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoDeCobranca tipoCobranca;

    private LocalDateTime dataCriacao;

    public Produto() {
    }

}

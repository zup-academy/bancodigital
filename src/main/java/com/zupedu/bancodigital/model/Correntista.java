package com.zupedu.bancodigital.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "correntistas")
public class Correntista {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Past
    private LocalDate dataDeNascimento;

    @NotBlank
    @CPF
    private String documento;

    @Positive
    private BigDecimal patrimonioDeclarado;

    /**
     * @deprecated para frameworks apenas
     */
    @Deprecated
    public Correntista() { }

    public Correntista(String nome,
                       LocalDate dataDeNascimento,
                       String documento,
                       BigDecimal patrimonioDeclarado) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.documento = documento;
        this.patrimonioDeclarado = patrimonioDeclarado;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correntista that = (Correntista) o;
        return Objects.equals(documento, that.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}

package com.zupedu.bancodigital.controller.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zupedu.bancodigital.model.Correntista;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class NovoCorrentistaRequest {

    @NotBlank
    private String nome;

    @Past
    private LocalDate dataDeNascimento;

    @NotBlank
    @CPF
    private String documento;

    @Positive
    private BigDecimal patrimonioDeclarado;

    @JsonCreator(mode = PROPERTIES)
    public NovoCorrentistaRequest(String nome,
                                  LocalDate dataDeNascimento,
                                  String documento,
                                  BigDecimal patrimonioDeclarado) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.documento = documento;
        this.patrimonioDeclarado = patrimonioDeclarado;
    }

    public Correntista paraCorrentista() {
        return new Correntista(nome, dataDeNascimento, documento, patrimonioDeclarado);
    }
}

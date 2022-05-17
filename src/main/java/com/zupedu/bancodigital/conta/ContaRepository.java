package com.zupedu.bancodigital.conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByDocumentoTitular(String documentoTitular);

    Optional<Conta> findByAgenciaAndNumero(int agencia, long numero);

}

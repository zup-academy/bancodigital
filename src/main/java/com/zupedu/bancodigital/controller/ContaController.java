package com.zupedu.bancodigital.controller;

import com.zupedu.bancodigital.repository.ContaRepository;
import com.zupedu.bancodigital.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(NovaContaRequest request,
                                      UriComponentsBuilder uriBuilder) {


        var conta = contaRepository.save(request.paraConta(correntistaRepository));

        var location = uriBuilder.path("/api/contas/{id}")
                .buildAndExpand(conta.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}

package com.zupedu.bancodigital.controller;

import com.zupedu.bancodigital.controller.input.NovoCorrentistaRequest;
import com.zupedu.bancodigital.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/correntista")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository correntistaRepository;


    @PostMapping
    public ResponseEntity<?> cadastra(NovoCorrentistaRequest request,
                                      UriComponentsBuilder uriBuilder) {


        var correntista = correntistaRepository.save(request.paraCorrentista());

        var location = uriBuilder.path("/api/correntista/{id}")
                .buildAndExpand(correntista.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}

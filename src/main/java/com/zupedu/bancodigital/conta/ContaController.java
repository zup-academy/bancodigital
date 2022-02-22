package com.zupedu.bancodigital.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    public ContaRepository contaRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ContaResponse criar(@RequestBody ContaRequest request){
        var conta = request.getConta();

        conta = contaRepository.save(conta);

        return ContaResponse.of(conta);
    }
}

package com.zupedu.bancodigital.transferencia;

import com.zupedu.bancodigital.conta.ContaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    Logger logger = LoggerFactory.getLogger(TransferenciaController.class);
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping
    public TransferenciaResponse inserir(@Valid @RequestBody TransferenciaRequest request){

        var transferencia = request.toModel(contaRepository);

        transferenciaRepository.save(transferencia);

        return TransferenciaResponse.from(transferencia);
    }

}

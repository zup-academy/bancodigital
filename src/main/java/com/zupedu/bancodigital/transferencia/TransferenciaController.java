package com.zupedu.bancodigital.transferencia;

import com.zupedu.bancodigital.conta.ContaRepository;
import com.zupedu.bancodigital.pagamento.PagamentoRealizadoProducer;
import com.zupedu.bancodigital.pagamento.TipoPagamentoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private PagamentoRealizadoProducer pagamentoRealizadoService;

    @Value("${application.name}")
    private String aplicationName;

    @PostMapping
    public TransferenciaResponse inserir(@Valid @RequestBody TransferenciaRequest request){

        var transferencia = request.toModel(contaRepository);

        transferenciaRepository.save(transferencia);

        pagamentoRealizadoService.send(transferencia.getValor(),
                transferencia.getContaOrigem().getNumero(),
                transferencia.getContaOrigem().getAgencia(),
                aplicationName, TipoPagamentoEnum.TED);

        return TransferenciaResponse.from(transferencia);
    }

}

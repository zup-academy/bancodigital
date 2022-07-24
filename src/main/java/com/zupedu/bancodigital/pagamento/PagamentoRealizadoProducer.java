package com.zupedu.bancodigital.pagamento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PagamentoRealizadoProducer {
    Logger logger = LoggerFactory.getLogger(PagamentoRealizadoProducer.class);

    @Value("${cloud.aws.queue.name}")
    private String queue;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    private void send(PagamentoRealizado payload) {

        Message<PagamentoRealizado> mensagem = MessageBuilder.withPayload(payload).build();

        messagingTemplate.convertAndSend(queue, mensagem);

        logger.info("Mensagem enviada : {}", payload);
    }

    @Async
    public void send(BigDecimal valor, long numeroConta,
                     int agenciaConta, String origem,
                     TipoPagamentoEnum tipoPagamento){
        PagamentoRealizado pagamentoRealizado =
                new PagamentoRealizado(valor, numeroConta,
                        agenciaConta, origem, tipoPagamento);

        send(pagamentoRealizado);
    }


}

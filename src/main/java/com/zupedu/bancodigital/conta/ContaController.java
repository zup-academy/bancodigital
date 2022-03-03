package com.zupedu.bancodigital.conta;

import com.zupedu.bancodigital.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ContaResponse criar(@RequestBody ContaRequest request){
        var conta = request.getConta(produtoRepository);

        conta = contaRepository.save(conta);

        return ContaResponse.of(conta);
    }
}

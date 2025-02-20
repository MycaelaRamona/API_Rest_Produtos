package io.github.mycaelaramona.produtosapi.controller;


import io.github.mycaelaramona.produtosapi.model.Produto;
import io.github.mycaelaramona.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
//O controller é a class quem recebe as requisições.
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /*Aqui estou mapeando (o post é quando eu vou salvar, vou criar um recurso
        no servidor.) NOTA: Tudo que você envia ou recebe de um servidor REST é chamado de recurso.*/
    @PostMapping
    public Produto salvar(@RequestBody Produto produto){

        System.out.println("Produto recebido: " + produto);
        //Aqui eu precisei gerar o id e atribuir ele ao produto do meu post( antes de salvar o produto).
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);

        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){

        //para eu criar a variável eu escrevo .var após o findById e ele me cria uma variável de forma automática, sugerindo nomes.
        Optional<Produto> produto = produtoRepository.findById(id);
        return  produto.isPresent() ? produto.get() : null;

        //Outra alternativa seria:
        //return produtoRepository.findById(id).orElse(null);
    }

}

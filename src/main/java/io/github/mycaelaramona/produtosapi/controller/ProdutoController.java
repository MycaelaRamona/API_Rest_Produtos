package io.github.mycaelaramona.produtosapi.controller;


import io.github.mycaelaramona.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
//O controller é a class quem recebe as requisições.
public class ProdutoController {

    @PostMapping /*Aqui estou mapeando (o post é quando eu vou salvar, vou criar um recurso
    no servidor.) NOTA: Tudo que você envia ou recebe de um servidor REST é chamado de recurso.*/
    public void salvar(Produto produto){

        System.out.println("Produto recebido: " + produto);
    }

}

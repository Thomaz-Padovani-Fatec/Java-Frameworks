package br.edu.fatec.tecnicas_demo.controller;

import br.edu.fatec.tecnicas_demo.model.Produto;
import br.edu.fatec.tecnicas_demo.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController diz que o método é gerenciado pelo Spring,
// igual @Service e @Repository, e que os métodos devem responder
// pela web, devolvendo dados (JSON) ao invés de uma página HTML.

// @RequestMapping define o prefixo da rota de TODOS os métodos
// desta classe: todas as URLs abaixo começam com /produtos.
@RestController
@RequestMapping("/produtos") public class ProdutoController {
    // Injeção pelo construtor, respeitando a regra de dependência entre camadas.
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
      this.service = service;
    }

    // @PostMapping liga esse método à rota POST /produtos.
    // @RequestParam captura os valores da URL e já converte para os tipos certos.
    @PostMapping
    public String cadastrar(@RequestParam String nome, @RequestParam double preco) {
      service.cadastrar(nome, preco);
      return "Produto cadastrado: " + nome;
    }

    // @GetMapping liga esse método à rota GET /produtos.
    // O retorno é convertido automaticamente para JSON pelo Spring.
    @GetMapping
    public List<Produto> listar() {
      return service.listar();
    }
}
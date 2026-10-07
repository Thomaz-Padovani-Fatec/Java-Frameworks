package br.edu.fatec.tecnicas_demo.service;

import br.edu.fatec.tecnicas_demo.model.Produto;
import br.edu.fatec.tecnicas_demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// @Service marca esta classe como a camada de regras de negócio.
@Service
public class ProdutoService {
  // A dependência é final porque só pode ser atribuída uma vez.
  // Ela chega pronta e não muda depois.
  private final ProdutoRepository repository;

  // Injeção pelo construtor: o Spring vê que o construtor
  // pede um ProdutoRepository, encontra o bean já criado
  // por causa do @Repository de antes e entrega sozinho,
  // sem que a classe precise fazer "new ProdutoRepository()".
  public ProdutoService(ProdutoRepository repository) {
    this.repository = repository;
  }

  public void cadastrar(String nome, double preco) {
    if (preco <= 0) throw new IllegalArgumentException("Preço deve ser maior que zero");
    repository.salvar(new Produto(nome, preco));
  }

  public List<Produto> listar() {
    return repository.listarTodos();
  }
}
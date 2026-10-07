package br.edu.fatec.tecnicas_demo.repository;

import br.edu.fatec.tecnicas_demo.model.Produto;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

// @Repository vai avisar o Spring para gerenciar essa classe.
// É com essa anotação que o container consegue instanciar essa
// classe por conta própria e entregar para quem precisar.
@Repository
public class ProdutoRepository {
  private List<Produto> produtos = new ArrayList<>();

  // Lista em memória só de exemplo, na prática seria um banco de verdade.
  public void salvar(Produto produto) {
    produtos.add(produto);
  }

  public List<Produto> listarTodos() {
    return produtos;
  }
}
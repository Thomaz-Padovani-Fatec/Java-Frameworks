package br.edu.fatec.tecnicas_demo.model;

// Classe comum, sem nenhuma anotação do Spring (Sem @).
// Não conhece banco de dados, HTTP nem nenhuma outra camada.
// É o modelo do noss produto no nosso projeto.
public class Produto {
  private String nome;
  private double preco;

  public Produto(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() { return nome; }
  public double getPreco() { return preco; }
}

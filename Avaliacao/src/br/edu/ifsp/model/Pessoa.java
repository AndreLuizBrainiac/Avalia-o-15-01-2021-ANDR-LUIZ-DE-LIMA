package br.edu.ifsp.model;

public class Pessoa {

	private int id;
	private String nome;
	private int idade;
	
	public Object[] toArray() {
    	return new Object[] {id, nome, idade};
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
    public String toString() {
        return String.format("ID: %s, NOME: %s e IDADE: %d",id,nome,idade);
    }

}

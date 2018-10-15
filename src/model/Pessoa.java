package model;

import java.util.ArrayList;
import java.util.HashMap;

import estrutura.ArvoreBusca;

public class Pessoa {
	private String nome;
	private ArvoreBusca<Integer, Pessoa> amigos;
	private ArvoreBusca<Integer, Postagem> postagens;

	public Pessoa(String nome) {
		this.nome = nome;
		this.amigos = new ArvoreBusca<>();
		this.postagens = new ArvoreBusca<>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArvoreBusca<Integer, Pessoa> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArvoreBusca<Integer, Pessoa> amigos) {
		this.amigos = amigos;
	}

	public ArvoreBusca<Integer, Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(ArvoreBusca<Integer, Postagem> postagens) {
		this.postagens = postagens;
	}



	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
	

	
}

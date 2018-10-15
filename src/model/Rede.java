package model;

import java.util.HashSet;

import estrutura.ArvoreBusca;

public class Rede {
	private ArvoreBusca<Integer, HashSet<Pessoa>> pessoas;
	
	public Rede() {
		this.pessoas = new ArvoreBusca<>();
	}

	public ArvoreBusca<Integer, HashSet<Pessoa>> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArvoreBusca<Integer, HashSet<Pessoa>> pessoas) {
		this.pessoas = pessoas;
	}

	
}

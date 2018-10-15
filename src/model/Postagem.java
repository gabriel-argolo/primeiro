package model;

import java.util.ArrayList;

public class Postagem {
	final private String texto;
	final private ArrayList<Pessoa> pessoas;
	
	public Postagem(String texto, ArrayList<Pessoa> pessoas) {
		this.texto = texto;
		this.pessoas = pessoas;
	}

	public String getTexto() {
		return texto;
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
	 
}


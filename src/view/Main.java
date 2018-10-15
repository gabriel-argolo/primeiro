/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import estrutura.ArvoreBusca;
import estrutura.No;
import model.Pessoa;
import model.Rede;


public class Main {
	public Pessoa criarPessoa() {
		System.out.println("Insira nome:");
		Scanner scan = new Scanner(System.in);
		Pessoa pessoa = new Pessoa(scan.nextLine());
		scan.close();
		return pessoa;
	}
	
	public Pessoa decidirPessoa(HashSet<Pessoa> pessoas) {
		if (pessoas.size() == 1) {
			return (Pessoa) pessoas.toArray()[0];	
		}else {
			Pessoa[] lista = (Pessoa[]) pessoas.toArray();
			for (int i = 0; i<lista.length; i++) {
				System.out.println(i+")"+lista[i].getNome());
			}
			
			Scanner scan = new Scanner(System.in);
			int opcao = Integer.parseInt(scan.nextLine());
			
			while (opcao <0 && opcao > lista.length) {
				System.out.println("Posição inválida!");
				opcao = Integer.parseInt(scan.nextLine());
			}
			
			scan.close();
			return lista[opcao]; 
		}
	}
	
	public Pessoa decidirPessoa(ArvoreBusca<Integer, Pessoa> pessoas) {
		ArrayList<No<Integer, Pessoa>> escolhidos = pessoas.listarOrdem();
		
		for (int i = 0; i<escolhidos.size(); i++) {
			System.out.println(i+")"+escolhidos.get(i).getValor().getNome());
		}
		
		Scanner scan = new Scanner(System.in);
		int opcao = Integer.parseInt(scan.nextLine());
		
		while (opcao <0 && opcao > escolhidos.size()) {
			System.out.println("Posição inválida!");
			opcao = Integer.parseInt(scan.nextLine());
		}
		
		scan.close();
		return escolhidos.get(opcao).getValor(); 
	}
	
	public boolean adicionarAmigo(Rede rede) {
		System.out.println("Insira nome para buscar");
		Scanner scan = new Scanner(System.in);
		No<Integer, HashSet<Pessoa>> no = rede.getPessoas().buscarNo(scan.nextLine().hashCode());
		scan.close();
		if (no == null) {
			System.out.println("Busca vazia");
			return false;
		}else {
			HashSet<Pessoa> pessoas = no.getValor();
			Pessoa anfitriao = decidirPessoa(pessoas);
			Pessoa convidado = decidirPessoa(anfitriao.getAmigos());
			
			anfitriao.getAmigos().adicionar(convidado.hashCode(), convidado);
			convidado.getAmigos().adicionar(anfitriao.hashCode(), anfitriao);
			return true;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		Rede rede = new Rede();
		Main menu = new Main();
		while (true) {
			Scanner scan = new Scanner(System.in);
			int opcao = Integer.parseInt(scan.nextLine());
			
			switch (opcao) {
				case 1:
					Pessoa pessoa = menu.criarPessoa();
					No <Integer, HashSet<Pessoa>> no = rede.getPessoas().buscarNo(pessoa.hashCode());
					if (no == null) {
						rede.getPessoas().adicionar(pessoa.hashCode(), new HashSet<>());
					}
					no.getValor().add(pessoa);
					break;
			}
		}
	
	}

}

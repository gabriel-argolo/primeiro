package estrutura;
import java.util.ArrayList;

public class ArvoreBusca<K extends Comparable<K>, V> {
	No<K, V> raiz;
	int tamanho;

	public void adicionar(K chave, V valor) {
		if (raiz == null) {
			raiz = new No<K, V>(chave, valor, null);
			tamanho++;
		}else {
			No<K, V> no = raiz;
			boolean encontrou = false;
			do{
				if (chave.compareTo(no.chave) > 0) {
					if (no.direito == null) {
						no.direito = new No<K, V>(chave, valor, no);
						encontrou = true;
						tamanho++;
					}else {
						no = no.direito;

					}
				}else if (chave.compareTo(no.chave) < 0) {
					if (no.esquerdo == null) {
						no.esquerdo = new No<K, V>(chave, valor, no);
						encontrou = true;
						tamanho++;
					}else {
						no = no.esquerdo;
					}
				}else {
					no.valor = valor;
					encontrou=true;
				}
			}while (!encontrou);
		}
	}
	
	public V buscar(K chave) {
		No<K, V> no = raiz;
		boolean encontrou = false;
		do {
			if (no == null) {
				encontrou = true;
			}else if (chave.compareTo(no.chave) > 0) {
				no = no.direito;
			}else if (chave.compareTo(no.chave) < 0) {
				no = no.esquerdo;
			}else {
				encontrou = true;
			}
		}while (!encontrou);
		return no.valor;
	}

	public No<K, V> buscarNo(K chave) {
		No<K, V> no = raiz;
		boolean encontrou = false;
		do {
			if (no == null) {
				encontrou = true;
			}else if (chave.compareTo(no.chave) > 0) {
				no = no.direito;
			}else if (chave.compareTo(no.chave) < 0) {
				no = no.esquerdo;
			}else {
				encontrou = true;
			}
		}while (!encontrou);
		return no;
	}

	public void remover(K chave) {
		No<K, V> no = buscarNo(chave);
		if (no != null) {
			if (no.esquerdo == null && no.direito == null) {
				if (no != raiz) {
					if (no.chave.compareTo(no.pai.chave) > 0) {
						no.pai.direito = null;

					} else {
						no.pai.esquerdo = null;
					}
					tamanho--;
				} else {
					raiz = null;
					tamanho--;
				}
			} else if (no.direito != null && no.esquerdo == null) {
				if (no != raiz) {
					if (no.chave.compareTo(no.pai.chave) > 0) {
						no.direito.pai = no.pai;
						no.pai.direito = no.direito;
					} else {
						no.direito.pai = no.pai;
						no.pai.esquerdo = no.direito;
					}
				} else {
					no.direito.pai = null;
					raiz = no.direito;
				}
			} else if (no.direito == null && no.esquerdo != null) {
				if (no != raiz) {
					if (no.chave.compareTo(no.pai.chave) > 0) {
						no.esquerdo.pai = no.pai;
						no.pai.direito = no.esquerdo;
					} else {
						no.esquerdo.pai = no.pai;
						no.pai.esquerdo = no.esquerdo;
					}
				} else {
					no.esquerdo.pai = null;
					raiz = no.direito;
				}
			} else {
				No<K, V> proximo = no.direito;

				while (proximo.esquerdo != null) {
					proximo = proximo.esquerdo;
				}

				remover(proximo.chave);
				no = buscarNo(no.chave);

				if (no == raiz) {
					raiz = proximo;
					proximo.pai = null;
					proximo.esquerdo = no.esquerdo;
					proximo.direito = no.direito;
					no.direito.pai = proximo;
					no.esquerdo.pai = proximo;
				}else {
					proximo.pai = no.pai;
					proximo.esquerdo = no.esquerdo;
					proximo.direito = no.direito;
					no.direito.pai = proximo;
					no.esquerdo.pai = proximo;
				}
			}
		}
	}

	public ArrayList<No<K,V>> listarPreOrdem() {
		ArrayList<No<K ,V>> lista = new ArrayList<>();
		listarPreOrdem(raiz, lista);
		return lista;
	}

	public ArrayList<No<K,V>> listarPosOrdem() {
		ArrayList<No<K ,V>> lista = new ArrayList<>();
		listarPosOrdem(raiz, lista);
		return lista;
	}

	public ArrayList<No<K,V>> listarOrdem() {
		ArrayList<No<K ,V>> lista = new ArrayList<>();
		listarOrdem(raiz, lista);
		return lista;
	}

	void listarPreOrdem(No<K, V> no, ArrayList<No<K, V>> lista) {
		if (no != null) {
			lista.add(no);
			listarPreOrdem(no.esquerdo, lista);
			listarPreOrdem(no.direito, lista);
		}
	}

	void listarPosOrdem(No<K, V> no, ArrayList<No<K, V>> lista) {
		if (no != null) {
			lista.add(no);
			listarPosOrdem(no.direito, lista);
			listarPosOrdem(no.esquerdo, lista);
		}
	}

	void listarOrdem(No<K, V> no, ArrayList<No<K, V>> lista) {
		if (no != null) {
			listarOrdem(no.esquerdo, lista);
			lista.add(no);
			listarOrdem(no.direito, lista);
		}
	}
}
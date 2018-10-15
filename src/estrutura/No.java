package estrutura;

public class No<K extends Comparable<K>, V> {
	protected V valor;
	protected K chave;
	
	protected No<K, V> pai;
	protected No<K, V> direito;
	protected No<K, V> esquerdo;
	
	public No(K chave, V valor, No<K, V> pai) {
		super();
		this.valor = valor;
		this.chave = chave;
		this.direito = null;
		this.esquerdo = null;
		this.pai = pai;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public K getChave() {
		return chave;
	}

	public void setChave(K chave) {
		this.chave = chave;
	}

	public No<K, V> getPai() {
		return pai;
	}

	public void setPai(No<K, V> pai) {
		this.pai = pai;
	}

	public No<K, V> getDireito() {
		return direito;
	}

	public void setDireito(No<K, V> direito) {
		this.direito = direito;
	}

	public No<K, V> getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No<K, V> esquerdo) {
		this.esquerdo = esquerdo;
	}
}

package estrutura;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author gabri
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArvoreBusca<Integer, String> a = new ArvoreBusca<>();

		a.adicionar(20, "20");
		a.adicionar(19, "19");
		a.adicionar(25, "25");
		a.adicionar(18, "18");
		a.adicionar(22, "22");
		a.adicionar(26, "26");
		a.adicionar(2, "2");
		a.adicionar(5, "5");

		a.remover(20);
		a.remover(22);
		
		ArrayList<No<Integer, String>> lista = a.listarOrdem();
		for (No<Integer, String> no: lista) {
			System.out.println(no.getValor());
		}
	}
}
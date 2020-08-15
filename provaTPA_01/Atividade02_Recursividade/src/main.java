import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		/* 	
		  	02 – Desenvolva um método recursivo retorne em uma String todos números divisíveis por X de zero a N.

			Depois você deve de criar um vídeo no youtube de até 10 minutos onde você apresenta como desenvolveu 
			este projeto, é importante que explique o funcionamento da mecânica do seu algoritmo. 
		 */

		Integer divisor = 0, n = 0;
		
		HashMap<String, Integer> valores = obterValores(divisor, n);

		ArrayList numeros = recursivoDivisor(valores.get("divisor"), valores.get("n"), new ArrayList<Integer>());

		exibirResultados(numeros, valores.get("divisor"));
	}
	
	/* 
	 * método recursivo para obter valores para operação
	 */
	private static HashMap<String, Integer> obterValores(Integer divisor, Integer n) {
		try {
			divisor = Integer.parseInt(JOptionPane.showInputDialog("Qual será o fator divisor da operação?"));
			n = Integer.parseInt(JOptionPane.showInputDialog("Qual será o fator N que dará os dividendos da operação?"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro, tente novamente informando valores válidos ...");
			obterValores(divisor, n);
		}
		
		HashMap<String, Integer> valores= new HashMap();
		valores.put("divisor", divisor);
		valores.put("n", n);
		
		return valores;
	}

	/* 
	 * método recursivo para obter valores para exibição
	 */
	private static ArrayList<String> recursivoDivisor(Integer divisor, Integer n, ArrayList numerosExibicao) {
		if(n % divisor == 0) {
			numerosExibicao.add(n);
		}

		return n == 0 ? numerosExibicao : recursivoDivisor(divisor , n - 1, numerosExibicao);
	}

	/* 
	 * método para exibição de valores divisíveis
	 */
	private static void exibirResultados(ArrayList numeros, Integer divisor) {
		String saida = numeros.size() == 1 ? "Nenhum valor é divisível." : "Valores divisiveis por " + divisor + ": \n|";
		
		if(numeros.size() > 1) {
			for (int i = numeros.size() -1; i >= 0 ; i--) {
				saida += numeros.get(i) + "|";
			}	
		}

		System.out.println(saida);
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class util {

	public static String [] importarValores(String url) {
		BufferedReader dados = null;

		try {
			/*
			 * Leitura de arquivos
			 */
			dados = new BufferedReader(new FileReader(url));
			return dados.readLine().split(",");
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro durante o processo, tente novamente!");;
		}
		
		return new String[0];
	}
	
	public static Integer menuSistema() {
		String menu = "ⓈⒺⓁⒺⒸⒾⓄⓃⒺ ⓊⓂⒶ ⓄⓅⒸⒶⓄ";
		menu += "\n\n[ 1 ] - Selection Sort" +
				"\n[ 2 ] - Insertion Sort" +
				"\n[ 3 ] - Bubble Sort" +
				"\n[ 4 ] - Shell Sort" +
				"\n[ 5 ] - Quick Sort" +
				"\n[ 0 ] - Finalizar Programa";
		
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(menu));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insira valores válidos ..");
			return menuSistema();
		}	
	}

	public static int[] converterValores(String [] numeros) {
		int [] valores = new int [numeros.length];
		
		for (int i = 0; i < numeros.length - 1 ; i++) {
			valores[i] = Integer.parseInt(numeros[i]);
		}
		
		return valores;
	}
	
	public static String montaDados(int [] valores, int numeroTrocas, int numeroComparacoes, double time) {
		String dados = "O resultado da ordenação dos valores é:" +
				"\n\nNúmero de trocas: " + numeroTrocas +
				"\nNúmero de comparações: " + numeroComparacoes +
				"\nTempo de execução: " + time + "\n\n|";
		
		for (int i = 0; i < valores.length - 1 ; i++) {
			dados += valores[i] + "|";
		}
		
		return dados + "\n";
	}
}

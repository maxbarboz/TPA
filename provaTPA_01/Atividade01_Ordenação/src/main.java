import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

		/*
			01 – Desenvolver um projeto JAVA no eclipse que importe o arquivo randômico.txt para dentro de um vetor de inteiros, 
			depois programa deve de ordenar esta exata sequência usando cada um dos cinco métodos de ordenações passados.
			Bobble, selection, insert, shell e quick sort.

			Para cada um dos métodos deve de ser informado no console:
			Número de trocas, número de comparações e o tempo de processamento. 

			Depois você deve de criar um vídeo no youtube de até 15 minutos onde você apresenta como desenvolveu este projeto 
			e as principais diferenças entre os cinco métodos de ordenação implementados, explique também as vantagens e 
			desvantagens de cada método.
		 */

		String [] numeros = util.importarValores("/home/maxsuel/Área de Trabalho/teste.txt");
		int [] valores = util.converterValores(numeros);
		Integer opcao = null;

		do {
			opcao = util.menuSistema();

			switch (opcao) {
			case 1:
				System.out.println("Selection Sort:\n\n" + metodosOrdenacao.selectionSort(valores));
				break;
			case 2:
				System.out.println("Insertion Sort:\n\n" + metodosOrdenacao.insertionSort(valores));
				break;
			case 3:
				System.out.println("Bumbble Sort:\n\n" + metodosOrdenacao.bubbleSort(valores));
				break;
			case 4:
				System.out.println("Shell Sort Sort:\n\n" + metodosOrdenacao.shellSortClassico(valores));
				break;
			case 5:
				System.out.println("Quick Sort:\n\n" + metodosOrdenacao.quickSort(valores, valores[0], valores.length - 1));
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Programa finalizado ...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente ..");
				break;
			}
		}while(opcao != 0);

	}

}

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		/*
		 	03 – Dado o vetor abaixo, responda:


						{11, 13, 21, 28, 34, 43, 46, 48, 49, 57, 58, 66, 69, 75, 86, 90}

			-> Em uma pesquisa binária, quantas buscas serão feitas para localizar o valor 75 no vetor?

			-> Em uma pesquisa binária, quantas buscas serão feitas para detectar que o valor 2 não existe no vetor? 

			-> Entre a pesquisa binária e a pesquisa sequencial, qual seria a melhor para encontrar o número 13 neste vetor? 
			Justifique sucintamente.

			Depois você deve de criar um vídeo no youtube de até 10 minutos onde você apresenta a resolução desta, 
			é importante que explique o funcionamento da mecânica do algoritmo de busca binária usando de exemplo este vetor.
		 */

		int valorBusca = 0;
		int [] valores = {11, 13, 21, 28, 34, 43, 46, 48, 49, 57, 58, 66, 69, 75, 86, 90};
		
		try {
			valorBusca = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor para a busca"));
			buscarValor(valorBusca, valores);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error, tente novamente ...");
		}
		
	}
	
	private static void buscarValor(int valorBusca, int [] dados) {
		int meio = 0; 
		int inicio = 0;     
	    int fim = dados.length - 1;
	    int comparacao =  0;
	    boolean valorEncontrado = false;
	    
		 while (inicio <= fim && !valorEncontrado) {     
             meio = (inicio + fim)/2;
             
             comparacao ++;             
             if (valorBusca == dados[meio]) {
            	 valorEncontrado = true;
             }else if(valorBusca < dados[meio]) {
            	 fim = meio - 1;  
             }else {
            	 inicio = meio + 1;  
             }   
		 }  
		 
		 if(valorEncontrado)
			 imprimeResultadoBusca(valorBusca, meio, comparacao);
		 else
			 imprimeErro(comparacao);
		 
	}
	
	private static void imprimeResultadoBusca(int valorBusca, int valor, int comparacao) {
		String texto = "Posição do número " + valorBusca + " desejado é: " + valor + 
				"\n Número de comparações necessárias: " + comparacao;
		JOptionPane.showMessageDialog(null, texto);
	}
	
	private static void imprimeErro(int comparacao) {
		String texto = "Valor não encontrado na busca, número de comparações: " + comparacao;
		JOptionPane.showMessageDialog(null, texto);
	}

}


public class metodosOrdenacao {

	/*
	 * Método que realiza a odenação Selection Sort
	 */
	public static String selectionSort(int [] vet) {
		int numeroTrocas = 0, numeroComparacoes = 0;
		double time = System.currentTimeMillis();
		int min, aux;

		for (int i = 0; i < vet.length; i++) {
			min = i;
			for (int j = i+1; j < vet.length; j++) {
				numeroComparacoes++;
				
				if(vet[j] < vet[min]) {
					min = j;
				}
			}

			if(min != i) {
				aux = vet[min];
				vet[min] = vet[i];
				vet[i] = aux;
				numeroTrocas++;
			}
		}

		time = System.currentTimeMillis() - time;

		return util.montaDados(vet, numeroTrocas, numeroComparacoes, time);
	}

	/*
			Método que realiza a ordenação Insertion Sort
	 */
	public static String insertionSort(int [] vet) {
		int numeroTrocas = 0, numeroComparacoes = 0;
		double time = System.currentTimeMillis();
		int aux;

		for (int i = 0; i < vet.length; i++) {
			aux = vet[i];

			for (int j = i-1; j >= 0 && vet[j] > aux; j--) {
				numeroTrocas++;
				vet[j+1] = vet[j];
				vet[j] = aux;
			}
		}

		time = System.currentTimeMillis() - time;

		return util.montaDados(vet, numeroTrocas, numeroComparacoes, time);
	}

	/*
			Método que realiza a ordenação Insertion Sort
	 */
	public static String bubbleSort(int [] vet) {
		int numeroTrocas = 0, numeroComparacoes = 0;
		double time = System.currentTimeMillis();
		int aux;

		for (int i = 0; i < vet.length; i++) {
			for (int j = 0; j <vet.length; j++) {
				if(vet[i] < vet[j]) {
					numeroTrocas++;
					aux = vet[i];
					vet[i] = vet[j];
					vet[j] = aux;
				}
			}
		}

		time = System.currentTimeMillis() - time;

		return util.montaDados(vet, numeroTrocas, numeroComparacoes, time);
	}

	/*
			Método que realiza a ordenação Shell Sort Clássico
	 */
	public static String shellSortClassico(int [] vet) {
		int numeroTrocas = 0, numeroComparacoes = 0;
		double time = System.currentTimeMillis();
		int aux, j, pulo = vet.length/2;

		while(pulo>0) {
			for (int i = pulo; i < vet.length; i++) {
				aux = vet[i];
				j = i;

				while(j >= pulo && vet[j-pulo] > aux) {
					numeroTrocas++;
					vet[j] = vet[j-pulo];
					j = j - pulo;
				}
				vet[j] = aux;
			}
			pulo/=2;
		}
		
		time = System.currentTimeMillis() - time;

		return util.montaDados(vet, numeroTrocas, numeroComparacoes, time);
	}

	/*
		Método que realiza a ordenação Quick Sort
	 */
	public static String quickSort(int [] vet, int ini, int fim) {
		int numeroTrocas = 0, numeroComparacoes = 0;
		double time = System.currentTimeMillis();
		int meio;	
		
		if(ini < fim) {
			meio = particiona(vet, ini, fim);
			quickSort(vet, ini, meio);
			quickSort(vet, meio+1, fim);
		}
		
		time = System.currentTimeMillis() - time;

		return util.montaDados(vet, numeroTrocas, numeroComparacoes, time);
	}

	public static int particiona(int vet[], int ini, int fim) {
		int pivo, topo;
		pivo = vet[ini];
		topo = ini;

		for (int i = ini + 1; i <= fim; i++) {
			if(vet[i] < pivo) {
				vet[topo] = vet[i];
				vet[i] = vet[topo + 1];
				topo++;
			}
		}

		vet[topo] = pivo;
		return topo;
	}

}

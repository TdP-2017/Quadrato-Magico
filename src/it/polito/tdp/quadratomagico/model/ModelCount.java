package it.polito.tdp.quadratomagico.model;

public class ModelCount {

	int solutionsCounter;

	public int findMagicSquares(int dim) {

		// Ogni volta che cerco una soluzione ricorsiva,
		// azzera il contatore
		solutionsCounter = 0;

		// Creo un oggetto Square
		Square square = new Square(dim);

		// Chiamo la funzione ricorsiva
		int step = 0;
		recursive(square, step);

		// ritorno tutte le soluzioni trovate
		return solutionsCounter;
	}

	private void recursive(Square square, int step) {

		if (step >= square.getN2()) {
			if (square.checkMagicConst()) {
				solutionsCounter++;
			}
		}

		for (int i = 1; i <= square.getN2(); i++) {
			if (!square.contains(i)) {
				square.add(i);
				recursive(square, step + 1);
				square.remove(i);
			}
		}
		return;
	}

}

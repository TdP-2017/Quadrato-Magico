package it.polito.tdp.quadratomagico.model;

public class ModelFirst {

	public Square findMagicSquare(int dim) {

		// Creo un oggetto Square
		Square square = new Square(dim);

		// Chiamo la funzione ricorsiva
		int step = 0;

		return recursive(square, step);
	}

	private Square recursive(Square square, int step) {

		if (step >= square.getN2()) {
			if (square.checkMagicConst()) {
				return square;
			}
		}

		for (int i = 1; i <= square.getN2(); i++) {

			if (!square.contains(i)) {
				square.add(i);

				Square s = recursive(square, step + 1);
				// Controllo se il valore ritornato dalla funzione ricorsiva
				// e' diverso da null.
				if (s != null) {
					// Se e' diverso da null, interrompo la ricorsione, ho già trovato
					// una soluzione
					return s;
				}

				square.remove(i);
			}
		}

		return null;
	}

}

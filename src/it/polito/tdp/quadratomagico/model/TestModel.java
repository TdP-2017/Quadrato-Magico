package it.polito.tdp.quadratomagico.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		// *** Il model restituisce tutte le soluzioni trovate ***
		// ***
		Model model = new Model();
		List<Square> solutions = model.findMagicSquares(3);
		if (solutions != null && solutions.size() > 0) {

			System.out.println("Trovata almeno una soluzione");

			for (Square s : solutions) {
				System.out.println(s.toString());
			}

		} else {
			System.out.println("Nessuna soluzione trovata");
		}

		
		// *** Il model restituisce solo la prima soluzione trovata ***
		// ***
		ModelFirst modelFirst = new ModelFirst();
		Square solution = modelFirst.findMagicSquare(3);
		if (solution != null) {
			System.out.println("Trovata una soluzione");
			System.out.println(solution.toString());

		} else {
			System.out.println("Nessuna soluzione trovata");
		}

		
		// *** Il model restituisce solo il numero di soluzioni trovate ***
		// ***
		ModelCount modelCount = new ModelCount();
		int counter = modelCount.findMagicSquares(3);
		System.out.println(String.format("Numero di soluzioni trovate: %d\n", counter));

	}

}

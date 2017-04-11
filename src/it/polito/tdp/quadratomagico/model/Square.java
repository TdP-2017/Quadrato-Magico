package it.polito.tdp.quadratomagico.model;

import java.util.ArrayList;
import java.util.List;

public class Square {

	// ** id e next_id sono utilizzati solo per debug
	// Vengono utilizzati per assegnare un identificativo univico
	// a ciasun oggetto.
	
	// Next id è una variabile statica: 
	// Una variabile di classe è una variabile visibile da tutte le istanze
	// di quell’oggetto ed il suo valore non cambia da istanza ad istanza,
	// per questo appartiene trasversalmente a tutta la classe.
	private static int next_id = 0;
	
	// La keyword final per dichiarare una variabile che potrà essere
	// inizializzata una sola volta, sia nella fase di dichiarazione
	// o attraverso una successiva assegnazione 
	private final int id;

	// List come struttura dati per la mia griglia
	private List<Integer> griglia = null;
	private int N;
	private int N2;
	private int magicConst;

	public Square(Square square) {
		this.griglia = new ArrayList<Integer>(square.getGriglia());
		this.N = square.getN();
		this.N2 = N * N;
		this.magicConst = N * (N * N + 1) / 2;
		id = next_id;
		next_id += 1;
	}

	public Square(int dimension) {
		this.griglia = new ArrayList<Integer>();
		this.N = dimension;
		this.N2 = N * N;
		this.magicConst = N * (N * N + 1) / 2;
		id = next_id;
		next_id += 1;
	}

	public int getId() {
		return this.id;
	}

	public List<Integer> getGriglia() {
		return griglia;
	}

	public int getN() {
		return N;
	}

	public int getN2() {
		return N2;
	}

	public int getMagicConst() {
		return magicConst;
	}

	public boolean contains(int number) {
		return griglia.contains(number);
	}

	public void add(int number) {
		griglia.add(number);
	}

	public void remove(int number) {
		griglia.remove(Integer.valueOf(number));
	}

	public boolean checkMagicConst() {
		if (griglia.size() != N2) {
			return false;
		}

		// Controllare le righe
		if (!checkRows())
			return false;

		// Controllare le colonne
		if (!checkColumns())
			return false;

		// Controllare le diagonali
		if (!checkDiagonals()) {
			return false;
		}

		return true;
	}

	private boolean checkRows() {
		// matrice[i][j]
		// array[i*n + j]

		// 0,0 0,1 0,2
		// 1,0 1,1 1,2
		// 2,0 2,1 2,2

		// 0 1 2 3 = (1,0)....8

		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				tmp += griglia.get(i * N + j);
			}
			if (tmp != magicConst)
				return false;
		}

		return true;
	}

	private boolean checkColumns() {

		// 0,0 0,1 0,2
		// 1,0 1,1 1,2
		// 2,0 2,1 2,2

		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				tmp += griglia.get(j * N + i);
			}
			if (tmp != magicConst)
				return false;
		}

		return true;
	}

	private boolean checkDiagonals() {
		// 0,0 0,1 0,2
		// 1,0 1,1 1,2
		// 2,0 2,1 2,2

		int tmp = 0;
		for (int i = 0; i < N; i++)
			tmp += griglia.get(i * N + i);

		if (tmp != magicConst)
			return false;

		tmp = 0;
		for (int i = N - 1; i >= 0; i--) {
			tmp += griglia.get((N - 1 - i) * N + i);
		}

		if (tmp != magicConst)
			return false;

		return true;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("Square id: %d\n", id));
		
		if (griglia.size() > 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					sb.append(String.format("%d ", griglia.get(i * N + j)));
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}

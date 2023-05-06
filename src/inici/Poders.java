package inici;

import java.util.ArrayList;

import Teclat.*;
import altres.Poder;

public class Poders {

	public static ArrayList<Poder> llista = new ArrayList <Poder>();

	static void menu() {

		boolean eixir = false;
		while (!eixir) {
			int opcio = Teclat.lligOpcio("PODERS", "Crear", "Consultar", "Eliminar");

			switch (opcio) {
			case 1:
				crear();
				break;

			case 2:
				consultar();
				break;

			case 3:
				eliminar();
				break;

			case 0:
				eixir = true;

				break;
			}

		}

	}

	static void crear() {
		String nomPoder = Teclat.lligString("Nom del poder que vols crear: ");
		Poder nouPoder = new Poder(nomPoder);

		if (!Poders.llista.contains(nomPoder)) {
			int bA = Teclat.lligInt("Bonus atac del poder: ", 1, 100);
			int bD = Teclat.lligInt("Bonus defensa del poder: ", 1, 100);
			Poders.llista.add(new Poder(nomPoder, bA, bD));
			Pantalla.titolet("Poder afegit.");

		} else {
			System.out.println("Aquest poder ja existeix a la llista.");
		}

	}

	static void consultar() {

		System.out.println(Poders.llista);

	}

	static void eliminar() {
		String nomPoderEliminar = Teclat.lligString("Nom del poder que vols eliminar: ");
		Poder pEliminar = new Poder(nomPoderEliminar);
		if (Poders.llista.contains(pEliminar)) {
			Poders.llista.remove(pEliminar);
			Pantalla.titolet("¡¡¡PODER ELIMINAT!!!");

		} else {
			Pantalla.titolet("La llista no conté poder amb eixef nom.");
		}

	}

}

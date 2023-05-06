package inici;

import Teclat.*;
import altres.Equip;

import java.util.ArrayList;
import personatges.Huma;
import personatges.Jugador;
import personatges.*;

public class Jugadors {

	public static ArrayList<Jugador> llista = new ArrayList<Jugador>();

	static void menu() {

		boolean eixir = false;
		while (!eixir) {
			int opcio = Teclat.lligOpcio("JUGADORS", "Crear", "Consultar", "Eliminar", "Assignar a Equip",
					"Llevar d'equip", "Assignar Poder");

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
				case 4:
					assignarEquip();
					break;
				case 5:
					llevarEquip();
					break;
				case 6:
					assignarPoder();
					break;
				case 0:
					eixir = true;
					break;

			}

		}

	}

	static void crear() {

		String nom = Teclat.lligString("Nom del jugador:");
		Jugador j1 = new Jugador(nom);
		if (!llista.contains(j1)) {
			char tipus = Teclat.lligChar("Tipus de jugador.", "HGA");
			int pA = Teclat.lligInt("Punts d'atac:", 1, 100);
			int pD = 100 - pA;

			switch (tipus) {
				case 'H':

					llista.add(j1 = new Huma(nom, pA, pD, Jugador.getVidesInicials()));

					break;
				case 'G':
					llista.add(j1 = new Guerrer(nom, pA, pD, Jugador.getVidesInicials()));

					break;
				case 'A':
					llista.add(j1 = new Alien(nom, pA, pD, Jugador.getVidesInicials()));

					break;

			}
			// System.out.println(llista);

		} else {
			System.out.println();
			System.out.println("Aquesta llista ja conté un jugador amb aquest nom.");
		}

	}

	static void consultar() {
		for (Jugador jugador : llista) {
			System.out.println(jugador);

		}
	}

	static void eliminar() {
		String nom = Teclat.lligString("Nom del jugador que vols esborrar: ");
		Jugador nomEsborrar = new Jugador(nom);
		if (llista.contains(nomEsborrar)) {
			llista.remove(nomEsborrar);
			System.out.println();
			System.out.println("¡¡¡JUGADOR ESBORRAT!!!");
		} else {
			System.out.println("No hi ha cap jugador amb eixe nom.");
		}
	}

	static void assignarEquip() {
		Jugador jugAssignar = Jugadors.buscarJugador();

		try {
			if (jugAssignar.getEquip().getNom() == null) {

				Equip equipAssignar = Jugadors.buscarEquip();
				equipAssignar.posa(jugAssignar);
			}

		} catch (NullPointerException e) {
			System.out.println("Aquest Jugador o Equip no existeix.");
		}

	}

	static void llevarEquip() {
		Jugador jugLlevarEquip = Jugadors.buscarJugador();

		try {
			if (jugLlevarEquip.getEquip().getNom() != null) {
				Equip eLlevar = Jugadors.buscarEquip();
				eLlevar.lleva(jugLlevarEquip.getNom());
			}
		} catch (NullPointerException e) {
			System.out.println("Aquest jugador no tenia equip assignat");
		}

	}

	static void assignarPoder() {
		Jugador jugAssignar = buscarJugador();

	}

	/**
	 * Demana per teclat un nom de jugador per a buscar-lo en la llista de jugadors
	 * 
	 * @return l'objecte jugador trobat o bé null si no ha trobat el jugador
	 */
	static Jugador buscarJugador() {

		String nomJug = Teclat.lligString("Nom del Jugador: ");
		return buscarJugador(nomJug);

	}

	public static Jugador buscarJugador(String nomJug) {

		Jugador jugTrobat;
		jugTrobat = new Jugador(nomJug);
		int indexJug = llista.indexOf(jugTrobat);
		if (indexJug != -1) {
			jugTrobat = llista.get(indexJug);
			return jugTrobat;

		} else {
			return null;
		}

	}

	/**
	 * Demana per teclat el nom del equip per a buscar-lo en la llista d'equips.
	 * 
	 * @return l'objecte equip trobat o bé null si no ha trobat el equip.
	 */
	static Equip buscarEquip() {

		String nomEquipAssignarLlevar = Teclat.lligString("Nom del equip on vols assignar-lo/llevar-lo: ");
		Equip equipTrobat;
		equipTrobat = new Equip(nomEquipAssignarLlevar);
		int indexEquip = Equips.llista.indexOf(equipTrobat);
		if (indexEquip != -1) {
			equipTrobat = Equips.llista.get(indexEquip);
			return equipTrobat;

		} else {
			return null;
		}

	}
}

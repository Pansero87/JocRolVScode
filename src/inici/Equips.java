package inici;

import Teclat.*;

import java.util.ArrayList;

import altres.Equip;

public class Equips {

	public static ArrayList<Equip> llista = new ArrayList<Equip>();

	static void menu() {

		boolean eixir = false;
		while (!eixir) {
			int opcio = Teclat.lligOpcio("EQUIPS", "Crear", "Consultar", "Eliminar");

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
		String nEquip = Teclat.lligString("Nom del equip que vols crear: ");
		Equip eCrear = new Equip(nEquip);
		if (!Equips.llista.contains(eCrear)) {
			Equips.llista.add(eCrear);
		} else {
			System.out.println("Aquest equip ja existeix a la llista.");
		}

	}

	static void consultar() {

		System.out.println(Equips.llista);
	}

	static void eliminar() {

		String nEquip = Teclat.lligString("Nom del equip que vols eliminar: ");
		Equip eEliminar = new Equip(nEquip);
		if (Equips.llista.contains(eEliminar)) {
			Equips.llista.remove(eEliminar);
			System.out.println("¡¡¡EQUIP ELIMINAT!!!");

		} else {
			System.out.println("Aquest equip no existeix a la llista.");
		}

	}

}

package personatges;

import altres.Equip;
import altres.Poder;

import java.util.ArrayList;
import java.util.Objects;

import Teclat.*;

public class Jugador implements Comparable<Jugador> {

	private String nom;
	private int puntsAtac;
	private int puntsDefensa;
	private int vides;

	private static int videsInicials = 200;
	private Equip equip = new Equip(null);

	private ArrayList<Poder> poders = new ArrayList<>();

	// CONSTRUCTOR

	public Jugador(String nom, int puntsAtac, int puntsDefensa, int vides) {

		this.nom = nom;
		this.puntsAtac = puntsAtac;
		this.puntsDefensa = puntsDefensa;
		this.vides = vides;

	}

	public Jugador(String nom) {
		this.nom = nom;
	}

	// GETTERS I SETTERS

	public static int getVidesInicials() {
		return videsInicials;
	}

	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
		equip.posa(this);
	}

	public String getNom() {
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	public int getPuntsAtac() {
		return puntsAtac;
	}

	protected void setPuntsAtac(int puntsAtac) {
		this.puntsAtac = puntsAtac;
	}

	public int getPuntsDefensa() {
		return puntsDefensa;
	}

	protected void setPuntsDefensa(int puntsDefensa) {
		this.puntsDefensa = puntsDefensa;
	}

	public int getVides() {
		return vides;
	}

	protected void setVides(int vides) {
		this.vides = vides;
	}

	// MÈTODE toString

	@Override
	public String toString() {

		return "\n" + nom + "[" + equip.getNom() + "]" + "(" + this.getClass().getSimpleName().toUpperCase() + ", PA:"
				+ getPuntsAtac() + ", PD:" + getPuntsDefensa() + ", PV:" + vides + ") té els poders: ";

	}

	// MÈTODE esColpejatAmb

	protected void esColpejatAmb(int puntsAtacAtacador) {
		Jugador victima = this;

		int videsAnteriors = victima.vides;

		int danyVerdader = puntsAtacAtacador - victima.getPuntsTotalsDefensa();

		if (victima.vides - danyVerdader <= 0) {
			victima.vides = 0;

		}

		if (puntsAtacAtacador > victima.getPuntsTotalsDefensa()) {
			if (victima.vides - danyVerdader > 0) {
				victima.vides -= danyVerdader;

			}

		}

		if (!(puntsAtacAtacador < victima.getPuntsTotalsDefensa())) {
			System.out.println(nom + " És colpejat amb " + puntsAtacAtacador + " PA, i es defèn amb "
					+ victima.getPuntsTotalsDefensa() + " PD" + " = "
					+ (puntsAtacAtacador - victima.getPuntsTotalsDefensa()) + " || VIDES: " + videsAnteriors + " - "
					+ danyVerdader + " = " + victima.vides);

		} else {
			System.out.println(victima.getNom() + " No sofreix dany, ja que el dany és inferior a la defensa.");
		}

		// Condició per a mostrar quan mor un personatge
		if (victima.vides == 0) {
			Pantalla.titol(getNom() + " HA MORT, el dany és superior a les seues vides.");

		}

	}

	public void ataca(Jugador atacat) {
		Jugador atacant = this;

		Pantalla.titol(this.getClass().getSimpleName() + " ATACA A UN " + atacat.getClass().getSimpleName());

		Pantalla.titolet("ABANS DE L'ATAC:");
		System.out.println("Atacant: " + atacant);
		System.out.println("Atacat: " + atacat);
		System.out.println();

		Pantalla.titolet("ATAC:");
		atacat.esColpejatAmb(atacant.getPuntsTotalsAtac());
		atacant.esColpejatAmb(atacat.getPuntsTotalsAtac());
		System.out.println();

		Pantalla.titolet("DESPRÉS DE L'ATAC:");
		System.out.println("Atacant: " + atacant);
		System.out.println("Atacat: " + atacat);

	}

	public int getPuntsTotalsAtac() {
		int puntsTA = this.getPuntsAtac();

		for (Poder poder : poders) {
			puntsTA += poder.getBonusAtac();
		}

		return puntsTA;

	}

	public int getPuntsTotalsDefensa() {
		int puntsTD = this.getPuntsDefensa();

		for (Poder poder : poders) {
			puntsTD += poder.getBonusDefensa();

		}
		return puntsTD;

	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jugador))
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nom, other.nom);
	}

	// Mètodes Posa, Lleva per posar o llevar poder al jugador

	public void posa(Poder poder) {
		poders.add(poder);

	}

	public void lleva(Poder poder) {
		poders.remove(poder);

	}

	@Override
	public int compareTo(Jugador j) {
		String e1 = this.getEquip().getNom();
		String e2 = j.getEquip().getNom();
		try {
			int resultatCoparacio = this.getEquip().getNom().compareTo(j.getEquip().getNom());
			if (resultatCoparacio == 0 && e1 != null && e2 != null) {
				return 0;
			}
		} catch (NullPointerException ex) {
			//
		}
		try {
			return this.getEquip().getNom().compareTo(j.getEquip().getNom()) > 0 ? 1 : -1;
		} catch (NullPointerException ex) {

		}
		return puntsAtac;

	}
}

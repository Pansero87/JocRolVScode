package altres;

import java.util.ArrayList;
import java.util.Objects;

import Teclat.Pantalla;
import inici.Equips;
import inici.Jugadors;
import personatges.Jugador;

public class Equip {

	private String nom;
	private ArrayList<Jugador> jugadors = new ArrayList();

	// GETTER I SETTER
	public String getNom() {
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	// CONSTRUCTOR
	public Equip(String nom) {
		this.nom = nom;
	}

	/**
	 * Afegeix el jugador que rep com a paràmetre a la llista de jugadors
	 * 
	 * @param jugador
	 */
	public void posa(Jugador jugador) {
		if (!jugadors.contains(jugador)) {
			jugadors.add(jugador);
			jugador.setEquip(this);
			Pantalla.titolet("Jugador " + "|" + jugador.getNom() + "|" + " afegit al equip: " + "|"
					+ jugador.getEquip().getNom() + "|");

		} else {

		}

	}

	public void lleva(String nom) {
		Jugador j1;
		j1 = new Jugador(nom);
		if (jugadors.contains(j1)) {

			jugadors.remove(j1);
			Jugadors.buscarJugador(nom).setEquip(new Equip(null));
			Pantalla.titolet("Jugador " + "|" + nom + "|" + " llevat del equip.");

		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

//	if (jugadors.contains((j1))) {
//		jugadors.remove(j1);

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equip other = (Equip) obj;
		return Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "\n" + "Equip: " + nom + "\t" + "-" + "\n" + jugadors;
	}

}

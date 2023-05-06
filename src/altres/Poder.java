package altres;

import java.util.Objects;

public class Poder {

	private String nom;

	private int bonusAtac;
	private int bonusDefensa;

	// Getter setter
	public int getBonusAtac() {
		return bonusAtac;
	}

	public void setBonusAtac(int bonusAtac) {
		this.bonusAtac = bonusAtac;
	}

	public int getBonusDefensa() {
		return bonusDefensa;
	}

	public void setBonusDefensa(int bonusDefensa) {
		this.bonusDefensa = bonusDefensa;
	}

	// Constructor
	public Poder(String nom) {
		super();
		this.nom = nom;
	}

	public Poder(String nom, int bonusAtac, int bonusDefensa) {
		super();
		this.nom = nom;
		this.bonusAtac = bonusAtac;
		this.bonusDefensa = bonusDefensa;
	}

	@Override
	public String toString() {
		return "\n" + nom + " (BA:" + bonusAtac + ", BD:" + bonusDefensa + ")";
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
		if (getClass() != obj.getClass())
			return false;
		Poder other = (Poder) obj;
		return Objects.equals(nom, other.nom);
	}

}

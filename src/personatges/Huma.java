package personatges;

import Teclat.*;

public class Huma extends Jugador {

	// CONSTRUCTOR

	public Huma(String nom, int puntsAtac, int puntsDefensa, int vides) {

		super(nom, puntsAtac, puntsDefensa, vides > 100 ? 100 : vides);

	}

}

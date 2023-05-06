package personatges;

import Teclat.*;

public class Guerrer extends Huma {

	private int setVides;

	// CONSTRUCTOR


	public Guerrer(String nom, int puntsAtac, int puntsDefensa, int vides) {
		super(nom, puntsAtac, puntsDefensa, vides);
	}

	@Override
	protected void esColpejatAmb(int puntsAtacAtacador) {
		Jugador victima = this;

		int danyVerdader = puntsAtacAtacador - victima.getPuntsTotalsDefensa();
		int ferida;

		if (danyVerdader < 5 && danyVerdader > 0) {
			ferida = danyVerdader;
		} else {
			ferida = 0;
		}

		if (puntsAtacAtacador > victima.getPuntsTotalsDefensa() && danyVerdader >= 5) {
			super.esColpejatAmb(puntsAtacAtacador);

		} else {
			System.out.println(victima.getNom()
					+ " al ser un Guerrer i la ferida ser lleu (menys de 5) el dany no li afecta. Ferida: " + ferida);

		}

	}
}

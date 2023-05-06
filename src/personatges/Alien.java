package personatges;

import Teclat.*;

public class Alien extends Jugador {

	// CONSTRUCTOR

	public Alien(String nom, int puntsAtac, int puntsDefensa, int vides) {
		super(nom, puntsAtac, puntsDefensa, vides);

	}

	public void ataca(Jugador atacat) {
		Jugador atacant = this;
		
		Pantalla.titol(this.getClass().getSimpleName() + " ATACA A UN " + atacat.getClass().getSimpleName());
		
		Pantalla.titolet("ABANS DE L'ATAC:");
		System.out.println("Atacant: " + atacant);
		System.out.println("Atacat: " + atacat);
		System.out.println();

		if (atacant.getVides() > 20) {
			int pD = atacant.getPuntsTotalsDefensa();
			int pA = atacant.getPuntsTotalsAtac();
			
			atacant.setPuntsAtac(pA + 3);
			atacant.setPuntsDefensa(pD - 3);

		}

		Pantalla.titolet("ATAC:");
		atacat.esColpejatAmb(atacant.getPuntsTotalsAtac());
		atacant.esColpejatAmb(atacat.getPuntsTotalsAtac());
		System.out.println();

		Pantalla.titolet("DESPRÉS DE L'ATAC:");
		System.out.println("Atacant: " + atacant);
		System.out.println("Atacat: " + atacat);
		System.out.println();
	}

}

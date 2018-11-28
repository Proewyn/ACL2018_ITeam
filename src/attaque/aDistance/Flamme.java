package attaque.aDistance;

import moteurJeu.Commande;
import personnage.Monstre;
import personnage.Personnage;

public class Flamme extends AttaqueADistance {

	public Flamme(int x, int y, Commande dir) {
		super(x, y, dir);
	}

	@Override
	protected void degat(Personnage m) {
		m.setHp(m.getHp()-1);

	}

}

package attaque.aDistance;

import personnage.Personnage;

public class Flamme extends AttaqueADistance {

	/**
	 * Cree une flamme
	 * @param x position en X
	 * @param y position en Y
	 * @param dir direction dans laquelle va le projectile
	 */
	public Flamme(int x, int y, int dir) {
		super(x, y, dir);
	}

	@Override
	protected void degat(Personnage m) {
		m.setHp(m.getHp()-1);
	}

}

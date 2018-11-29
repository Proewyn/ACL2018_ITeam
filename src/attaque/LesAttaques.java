package attaque;

import java.util.List;

import monJeu.MonJeu;
import attaque.aDistance.AttaqueADistance;

public class LesAttaques {

	private List<AttaqueADistance> attaques;
	
	/**
	 * Cree la liste d'attaque (projectile)
	 * @param a liste des attaques
	 */
	public LesAttaques(List<AttaqueADistance> a) {
		attaques = a;
	}
	
	/**
	 * Deplace les projectiles
	 * @param mj jeu dans lequel se deplace les projectiles
	 */
	public void deplacement(MonJeu mj) {
		for (AttaqueADistance ad : attaques) {
			ad.deplacement(mj);
		}
		cleanAttaque();
	}

	/**
	 * Efface les projectiles qui ont touche quelque chose
	 */
	private void cleanAttaque() {
		int i = 0;
		while (i < attaques.size()) {
			if (attaques.get(i).isaToucher()) {
				attaques.remove(i);
			}
			else {
				i++;
			}
		}
	}
	
	/**
	 * Ajoute un projectile a la liste des attaques
	 * @param a
	 */
	public void addAttaque(AttaqueADistance a) {
		attaques.add(a);
	}
	
	public List<AttaqueADistance> getAttaques() {
		return attaques;
	}

	/**
	 * Effectue les collision pour chaque projectile
	 * @param mj jeu dans lequel se deplace les projectiles
	 */
	public void collision(MonJeu mj) {
		for (AttaqueADistance a : attaques){
			a.collision(mj);
		}
	}

}

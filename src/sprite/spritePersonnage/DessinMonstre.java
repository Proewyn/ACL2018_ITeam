package sprite.spritePersonnage;

import java.awt.Graphics2D;
import java.awt.Image;
import monJeu.Bibliotheque;
import personnage.Hero;
import personnage.Monstre;

/**
 * @author damien
 *
 */
public abstract class DessinMonstre {
	
	protected Monstre m;
	protected Image imageMonstre;

	/**
	 * Constructeur pour dessiner les monstres
	 * @param m a dessiner
	 * @param dessinMonstre pour le monstre
	 */
	public DessinMonstre(Monstre m ,Image dessinMonstre) {
		this.m = m;
		this.imageMonstre = dessinMonstre;

	}

	public Monstre getMonstre() {
		return m;
	}

	/**
	 * Dessine le monstre
	 * @param hero sa portee
	 * @param crayon pour dessiner
	 */
	public void dessiner(Hero hero, Graphics2D crayon) {
		if(m.getHp()>0){
			crayon.drawImage(
					this.imageMonstre, 
					(this.m.getX() - hero.getXVue()) * Bibliotheque.TAILLE_CASE,
					(this.m.getY() - hero.getYVue())* Bibliotheque.TAILLE_CASE, 
					Bibliotheque.TAILLE_CASE, 
					Bibliotheque.TAILLE_CASE,null);
			}
	}
	
	/**
	 * Dessine le monstre dans toute la portee du hero
	 * @param hero avec sa portee et vision
	 * @param crayon pour dessiner
	 */
	public void dessinerVision(Hero hero, Graphics2D crayon) {
		if (Math.sqrt((hero.getX()-m.getX())*(hero.getX()-m.getX())+(hero.getY()-m.getY())*(hero.getY()-m.getY())) <= hero.getVision()){
			this.dessiner(hero,crayon);
		}
	}

}

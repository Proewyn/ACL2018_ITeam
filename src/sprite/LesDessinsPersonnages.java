/**
 * 
 */
package sprite;

import java.awt.Graphics2D;

import sprite.spritePersonnage.DessinHero;

/**
 * @author damien
 *
 */
public class LesDessinsPersonnages {
	private LesDessinsMonstres dessinsMonstres;
	private DessinHero dessinHero;

	/**
	 * 
	 * @param dessinHero
	 * @param dessinsMonstres
	 */
	public LesDessinsPersonnages(DessinHero dessinHero, LesDessinsMonstres dessinsMonstres) {
		this.dessinHero = dessinHero;
		this.dessinsMonstres = dessinsMonstres;
	}
	
	public void dessiner(Graphics2D crayon) {
		this.dessinHero.dessiner(crayon);
		this.dessinsMonstres.dessiner(crayon);
		
	}


}

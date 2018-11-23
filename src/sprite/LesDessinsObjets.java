/**
 * 
 */
package sprite;

import java.awt.Graphics2D;
import java.util.List;

import personnage.Hero;

import sprite.spriteObjet.DessinObjet;

/**
 * @author damien
 *
 */
public class LesDessinsObjets {
	private List<DessinObjet> dessinObjet;

	/**
	 * 
	 */
	public LesDessinsObjets(List<DessinObjet> dessinObjet) {
		this.dessinObjet = dessinObjet;
	}
	
	public void dessiner(Graphics2D crayon) {
		for(DessinObjet dObj : this.dessinObjet) {
			dObj.dessiner(crayon);
		}
		
	}

	public void dessinerVision(Hero hero, Graphics2D crayon) {
		for(DessinObjet dObj : this.dessinObjet) {
			dObj.dessinerVision(hero, crayon);
		}
		
	}
	


}

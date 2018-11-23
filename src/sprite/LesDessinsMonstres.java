/**
 * 
 */
package sprite;

import java.awt.Graphics2D;
import java.util.List;

import personnage.Hero;


import sprite.spritePersonnage.DessinMonstre;

/**
 * @author damien
 *
 */
public class LesDessinsMonstres{

	private List<DessinMonstre> dessinsMonstres;
	
	/**
	 * 
	 */
	public LesDessinsMonstres(List<DessinMonstre> dessinsMonstres) {
		this.dessinsMonstres = dessinsMonstres;
	}
	
	public void dessiner(Graphics2D crayon) {
		
		for(DessinMonstre dm : this.dessinsMonstres) {
			
			dm.dessiner(crayon);
		}
		
	}

	public void dessinerVision(Hero hero,Graphics2D crayon) {
		
		for(DessinMonstre dm : this.dessinsMonstres) {
			
			dm.dessinerVision(hero,crayon);
		}
	}
	


}

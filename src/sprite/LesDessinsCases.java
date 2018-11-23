/**
 * 
 */
package sprite;

import java.awt.Graphics2D;
import java.util.List;

import monJeu.Bibliotheque;

import personnage.Hero;
import plateau.Case;

import sprite.spriteCase.DessinCase;
import sprite.spriteCase.DessinSol;

/**
 * @author damien
 *
 */
public class LesDessinsCases {
	private DessinCase[][] dc;

	/**
	 * 
	 */
	public LesDessinsCases(DessinCase[][] dec) {
		this.dc = new DessinCase[dec.length][dec[0].length];
		for(int i = 0 ;i<dec.length;i++) {
			for(int j = 0 ;j<dec[0].length;j++) {
				this.dc[i][j] = dec[i][j];
				
			}
		}
		
		
		
	}
	

	
	public void dessiner(Graphics2D crayon) {
		for(int i = 0 ;i<dc.length;i++) {
			for(int j = 0 ;j<dc[0].length;j++) {
				
				this.dc[i][j].dessiner(i,j,crayon);
			}
		}
	}





	public void dessinerVision(Hero hero, Graphics2D crayon) {
		for(int i = 0 ;i<dc.length;i++) {
			for(int j = 0 ;j<dc[0].length;j++) {
				
				this.dc[i][j].dessinerVision(hero,i,j,crayon);
			}
		}
		
	}


}

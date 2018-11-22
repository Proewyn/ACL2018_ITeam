/**
 * 
 */
package sprite;

import java.awt.Graphics2D;
import java.util.List;

import sprite.spriteCase.DessinCase;

/**
 * @author damien
 *
 */
public class LesDessinsCases {
	private List<DessinCase> dc;

	/**
	 * 
	 */
	public LesDessinsCases(List<DessinCase> dc) {
		this.dc = dc;
	}
	
	public void dessiner(Graphics2D crayon) {
		for(DessinCase d : this.dc) {
			d.dessiner(crayon);
		}
	}
	


}

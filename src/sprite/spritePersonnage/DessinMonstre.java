/**
 * 
 */
package sprite.spritePersonnage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	 * 
	 */
	public DessinMonstre(Monstre m ,File urlImage) {
		this.m = m;
		this.imageMonstre = null;
		try {
			this.imageMonstre = ImageIO.read(urlImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public void dessiner(Graphics2D crayon) {
		if(m.getHp()>0){
		crayon.drawImage(
				this.imageMonstre, 
				this.m.getX() * Bibliotheque.TAILLE_CASE,
				this.m.getY() * Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE,null);
		}
		
		
	}



	public void dessinerVision(Hero hero, Graphics2D crayon) {
		if (Math.sqrt((hero.getX()-m.getX())*(hero.getX()-m.getX())+(hero.getY()-m.getY())*(hero.getY()-m.getY())) <= hero.getVision() ){
			
			this.dessiner(crayon);
		}
		
	}

}

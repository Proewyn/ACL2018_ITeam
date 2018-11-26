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
	public DessinMonstre(Monstre m ,Image dessinMonstre) {
		this.m = m;
		this.imageMonstre = dessinMonstre;

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

	public Monstre getMonstre() {
		return m;
	}

	public void dessinerVision(Hero hero, Graphics2D crayon) {
		if (Math.sqrt((hero.getX()-m.getX())*(hero.getX()-m.getX())+(hero.getY()-m.getY())*(hero.getY()-m.getY())) <= hero.getVision() ){
			
			this.dessiner(hero,crayon);
		}
		
	}




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

}

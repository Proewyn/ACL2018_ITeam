/**
 * 
 */
package sprite.spriteCase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import monJeu.Bibliotheque;
import personnage.Hero;
import plateau.Case;

/**
 * @author damien
 *
 */
public abstract class DessinCase {

	private Case c;
	protected Image dessinCase;
	
	/**
	 * 
	 */
	public DessinCase(Case c, Image dessinCase) {
		this.c = c;
		this.dessinCase = dessinCase;

	}
	

	
	public void dessiner(int x, int y,Graphics2D crayon) {
		crayon.setColor(Color.green);
		crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
		
	}

	


	public void dessinerVision(Hero hero, int i, int j, Graphics2D crayon) {
		
		if (Math.sqrt((hero.getX()-i)*(hero.getX()-i)+(hero.getY()-j)*(hero.getY()-j)) <= hero.getVision() ){
		
			this.dessiner(i,j,crayon);
		}
	}



	public void dessinerPortee(Hero hero, int i, int j, Graphics2D crayon) {
		/*
		 * for( int i = x_vue ; i < nb_vue_width + x_vue ; ++i )
		{
			for( int j = y_vue ; j < nb_vue_height + y_vue ; ++j )
			{
			graph_fond.drawRect( ( i - x_vue ) * tile_width + 2, ( j - y_vue ) * tile_height + 2, tile_width - 4, tile_height - 4 );
		 */
		this.dessiner(i,j,crayon);
	}
	

}

package sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;

import monJeu.Bibliotheque;
import objet.Objet;
import objet.Objets;
import personnage.Personnage;
import plateau.Plateau;
import sprite.spriteObjet.DessinCoffre;
import sprite.spriteObjet.DessinObjet;
import sprite.spriteObjet.DessinTeleporteur;
import sprite.spriteObjet.DessinTorche;

public class LesDessins {
	private LesDessinsObjets dessinObjets;
	private LesDessinsCases dessinCases;
	private LesDessinsPersonnages dessinPerso;

	public LesDessins(Objets o, Plateau p , Personnage ...persos) {
		ArrayList<DessinObjet> dessinObjet = new ArrayList<>();
		File urlImage = null;
		for (Objet obj : o.getObjets()) {
			int id = obj.getId();
			switch(id) {
			case Bibliotheque.TORCHE:
				urlImage = new File("/torche.png");
				dessinObjet.add(new DessinTorche(obj, urlImage));
				break;
			case Bibliotheque.TELEPORTEUR:
				urlImage = new File("/tp.png");
				dessinObjet.add(new DessinTeleporteur(obj, urlImage));
				break;
			case Bibliotheque.COFFRE:
				urlImage = new File("/coffre.png");
				dessinObjet.add(new DessinCoffre(obj, urlImage));				
				break;
			default:
				throw new AssertionError("objet inexistant");
			
			}
			
			
		}
			
		
		this.dessinObjets = new LesDessinsObjets(dessinObjet);
		
		
		
	}
	
	public void dessiner(Graphics2D crayon) {
		this.dessinCases.dessiner(crayon);
		this.dessinObjets.dessiner(crayon);
		this.dessinPerso.dessiner(crayon);
	}
	


}

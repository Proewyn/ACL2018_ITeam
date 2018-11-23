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
	private File urlTorche;
	private File urlTeleporteur;
	private File urlCoffre;
	private File urlCoffreDeClef;
	private File urlHero;
	private File urlMur;
	private File urlZombi;
	private File urlPorte;
	
	
	public LesDessins(Objets o, Plateau p , Personnage ...persos) {
		ArrayList<DessinObjet> dessinObjet = new ArrayList<>();
		
		for (Objet obj : o.getObjets()) {
			int id = obj.getId();
			switch(id) {
			case Bibliotheque.TORCHE:
				
				dessinObjet.add(new DessinTorche(obj, urlTorche));
				break;
			case Bibliotheque.TELEPORTEUR:
				
				dessinObjet.add(new DessinTeleporteur(obj, urlTeleporteur));
				break;
			case Bibliotheque.COFFRE:
				
				dessinObjet.add(new DessinCoffre(obj, urlCoffre));				
				break;
			default:
				throw new AssertionError("objet inexistant");
			
			}
			
		}
		this.dessinObjets = new LesDessinsObjets(dessinObjet);	
	}
	
	private void initUrl() {
		this.urlCoffre = new File("/coffre.png");
		this.urlCoffreDeClef = new File("/coffre.png");
		this.urlHero = new File("/hero1.png");
		this.urlZombi = new File("/mario_zombi.png");
		this.urlMur = new File("/mur1.png");
		this.urlPorte = new File("/porte.png");
		this.urlTeleporteur = new File("/tp.png");
		this.urlTorche = new File("/torche.png");
		
		
	}
	
	public void dessiner(Graphics2D crayon) {
		this.dessinCases.dessiner(crayon);
		this.dessinObjets.dessiner(crayon);
		this.dessinPerso.dessiner(crayon);
	}
	


}

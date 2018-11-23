package sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import monJeu.Bibliotheque;
import objet.Objet;
import objet.Objets;
import personnage.Hero;
import personnage.Monstre;
import plateau.Case;
import plateau.Plateau;
import sprite.spriteCase.DessinCase;
import sprite.spriteCase.DessinMur;
import sprite.spriteCase.DessinSol;
import sprite.spriteCase.DessinSpawn;
import sprite.spriteObjet.DessinCoffre;
import sprite.spriteObjet.DessinObjet;
import sprite.spriteObjet.DessinPorte;
import sprite.spriteObjet.DessinTeleporteur;
import sprite.spriteObjet.DessinTorche;
import sprite.spritePersonnage.DessinHero;
import sprite.spritePersonnage.DessinMonstre;
import sprite.spritePersonnage.DessinZombie;

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
	private File urlSol;
	
	
	public LesDessins(Objets o, Plateau p , Hero hero, List<Monstre>monstre) {
		this.initUrl();
		ArrayList<DessinObjet> dessinObjet = new ArrayList<>();
		int id = 0;
		for (Objet obj : o.getObjets()) {
			id = obj.getId();
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
			case Bibliotheque.PORTE:
				dessinObjet.add(new DessinPorte(obj, urlPorte));
				break;
			default:
				throw new AssertionError("objet inexistant"+id);
			
			}
			
		}
		this.dessinObjets = new LesDessinsObjets(dessinObjet);	
		

		Case[][]cases = p.getLaby();
		DessinCase[][] dc = new DessinCase[cases.length][cases[0].length] ;
		for(int i = 0 ;i<cases.length;i++) {
			for(int j = 0 ;j<cases[1].length;j++) {
				id = cases[i][j].getId();
				switch(id){
				case Bibliotheque.SOL:
					dc[i][j] = new DessinSol(cases[i][j], urlMur);
					break;
					
				case Bibliotheque.MUR:
					dc[i][j] = new DessinMur(cases[i][j], urlMur);
					break;
				case Bibliotheque.SPAWN:
					dc[i][j] = new DessinSpawn(cases[i][j], urlMur);
					break;
						
				}
			}
		}
		
		this.dessinCases= new LesDessinsCases(dc);
		
		ArrayList<DessinMonstre> dm = new ArrayList<>();
		for(Monstre m : monstre){
			id = m.getId();
			switch(id){
			case Bibliotheque.ZOMBI:
				dm.add(new DessinZombie(m, urlZombi));
			}
		}
		this.dessinPerso = new LesDessinsPersonnages(new DessinHero(hero, urlHero), new LesDessinsMonstres(dm));
		
		
	
	}
	
	private void initUrl() {
		this.urlCoffre = new File("sprites/coffre.png");
		this.urlCoffreDeClef = new File("sprites/coffre.png");
		this.urlHero = new File("sprites/hero1.png");
		this.urlZombi = new File("sprites/mario_zombi.png");
		this.urlMur = new File("sprites/mur1.png");
		this.urlPorte = new File("sprites/porte.png");
		this.urlTeleporteur = new File("sprites/tp.png");
		this.urlTorche = new File("sprites/torche.png");
		
		
	}
	
	public void dessiner(Graphics2D crayon) {
		this.dessinCases.dessiner(crayon);
		this.dessinObjets.dessiner(crayon);
		this.dessinPerso.dessiner(crayon);
	}

	public void dessinerVision(Hero hero,Graphics2D crayon){
		this.dessinCases.dessinerVision(hero,crayon);
		this.dessinObjets.dessinerVision(hero,crayon);
		this.dessinPerso.dessinerVision(hero,crayon);
	}

	


}

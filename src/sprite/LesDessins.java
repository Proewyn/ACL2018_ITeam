package sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
	private Image dessinTorche;
	private Image dessinTeleporteur;
	private Image dessinCoffre;
	private Image dessinCoffreDeClef;
	private Image dessinHero;
	private Image dessinMur;
	private Image dessinZombi;
	private Image dessinPorte;
	private Image dessinSol;
	private Image dessinFantome;
	private Image dessinGameOver;
	private Image dessinWin;
	
	public LesDessins(Objets o, Plateau p , Hero hero, List<Monstre>monstre) {
		this.initDessin();
		ArrayList<DessinObjet> dessinObjet = new ArrayList<>();
		int id = 0;
		for (Objet obj : o.getObjets()) {
			id = obj.getId();
			switch(id) {
			case Bibliotheque.TORCHE:
				
				dessinObjet.add(new DessinTorche(obj, dessinTorche));
				break;
			case Bibliotheque.TELEPORTEUR:
				
				dessinObjet.add(new DessinTeleporteur(obj, dessinTeleporteur));
				break;
			case Bibliotheque.COFFRE:
				
				dessinObjet.add(new DessinCoffre(obj, dessinCoffre));				
				break;
			case Bibliotheque.PORTE:
				dessinObjet.add(new DessinPorte(obj, dessinPorte));
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
					dc[i][j] = new DessinSol(cases[i][j], dessinSol);
					break;
					
				case Bibliotheque.MUR:
					dc[i][j] = new DessinMur(cases[i][j], dessinMur);
					break;
				case Bibliotheque.SPAWN:
					dc[i][j] = new DessinSpawn(cases[i][j], dessinMur);
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
				dm.add(new DessinZombie(m, dessinZombi));
				break;
			case Bibliotheque.FANTOME:
				dm.add(new DessinFantome(m, dessinFantome));
				break;
			}
		}
		this.dessinPerso = new LesDessinsPersonnages(new DessinHero(hero, dessinHero), new LesDessinsMonstres(dm));
		
		
	
	}


	
	private void initDessin() {
		try {
			this.dessinCoffre = ImageIO.read(new File("sprites/coffre.png"));
			this.dessinHero = ImageIO.read(new File("sprites/hero1.png"));
			this.dessinZombi = ImageIO.read(new File("sprites/zombi__.png"));
			this.dessinMur = ImageIO.read(new File("sprites/mur1.png"));
			this.dessinPorte = ImageIO.read(new File("sprites/porte.png"));
			this.dessinTeleporteur = ImageIO.read(new File("sprites/tp.png"));
			this.dessinTorche = ImageIO.read(new File("sprites/torche.png"));
			this.dessinFantome = ImageIO.read(new File("sprites/fantome.png"));
			this.dessinSol = ImageIO.read(new File("sprites/herbre.png"));
			//this.dessinGameOver = ImageIO.read(input);
			//this.dessinWin = ImageIO.read(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public void dessinerWin(Boolean b,BufferedImage im){
		if(b){
			DessinWin dessinWin;
			dessinWin = new DessinWin(dessinTorche);
			dessinWin.dessiner(im);
			
		}else{
			DessinGameOver dessinGameOver;
			dessinGameOver = new DessinGameOver(dessinMur);
			dessinGameOver.dessiner(im);
		}
		
		
	}

	


}

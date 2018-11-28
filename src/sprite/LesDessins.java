package sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import attaque.LesAttaques;
import attaque.aDistance.AttaqueADistance;

import monJeu.Bibliotheque;
import objet.Objet;
import objet.Objets;
import personnage.Hero;
import personnage.Monstre;
import plateau.Case;
import plateau.Plateau;
import sprite.spriteCase.DessinAttaque;
import sprite.spriteCase.DessinCase;
import sprite.spriteCase.DessinMur;
import sprite.spriteCase.DessinSol;
import sprite.spriteCase.DessinSpawn;
import sprite.spriteObjet.DessinCoffre;
import sprite.spriteObjet.DessinCoffreDeClef;
import sprite.spriteObjet.DessinObjet;
import sprite.spriteObjet.DessinPorte;
import sprite.spriteObjet.DessinTeleporteur;
import sprite.spriteObjet.DessinTorche;
import sprite.spritePersonnage.DessinFantome;
import sprite.spritePersonnage.DessinHero;
import sprite.spritePersonnage.DessinMonstre;
import sprite.spritePersonnage.DessinZombie;

public class LesDessins {
	private LesDessinsObjets dessinObjets;
	private LesDessinsCases dessinCases;
	private LesDessinsPersonnages dessinPerso;
	private DessinAttaque dessinAttaque;
		
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
	private Image dessinTorcheSuppreme;
	private Image dessinFlamme;
	
	/**
	 * Dessine tous les elements du plateau
	 * @param o l'element a dessiner
	 * @param p le plateau avec ses objets
	 * @param hero le hero
	 * @param monstre la liste des monstres
	 */
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
			case Bibliotheque.TORCHESUPPREME:
				dessinObjet.add(new DessinTorche(obj, dessinTorcheSuppreme));
				break;
			case Bibliotheque.COFFRECLE:
				dessinObjet.add(new DessinCoffreDeClef(obj, dessinCoffreDeClef));
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
		this.dessinAttaque = new DessinAttaque(dessinFlamme);
		
		this.dessinPerso = new LesDessinsPersonnages(new DessinHero(hero, dessinHero), new LesDessinsMonstres(dm));
		
	}

	/**
	 * Donne a chaque elements son sprite
	 */
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
			this.dessinCoffreDeClef = ImageIO.read(new File("sprites/coffreSupprem.png"));
			this.dessinTorcheSuppreme = ImageIO.read(new File("sprites/torche_suppreme.png"));
			this.dessinFlamme = ImageIO.read(new File("sprites/flamme.png"));
			this.dessinGameOver = dessinMur;
			this.dessinWin = dessinTorche;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Dessine les elements dans toute la portee du hero
	 * @param hero avec sa portee
	 * @param crayon qui dessine
	 * @param attaques a dessiner
	 */
	public void dessinerPortee(Hero hero, Graphics2D crayon ,LesAttaques attaques){
		this.dessinCases.dessinerPortee(hero, crayon);
		this.dessinObjets.dessinerPortee(hero,crayon);
		this.dessinPerso.dessinerPortee(hero,crayon);
		for(AttaqueADistance a : attaques.getAttaques()){
			this.dessinAttaque.dessinerPortee(hero, crayon, a);
		}
	}
	
	/**
	 * Dessine les elements dans toute la vision du hero
	 * @param hero avec sa portee et vision
	 * @param crayon qui dessine
	 * @param attaques a dessiner
	 */
	public void dessinerPorteeVision(Hero pj, Graphics2D crayon, LesAttaques attaques) {
		this.dessinCases.dessinerPorteeVision(pj, crayon);
		this.dessinObjets.dessinerPorteeVision(pj,crayon);
		this.dessinPerso.dessinerPorteeVision(pj,crayon);
		for(AttaqueADistance a : attaques.getAttaques()){
			this.dessinAttaque.dessinerPorteeVision(pj, crayon, a);
		}
	}
	
	/**
	 * Dessine l'ecran de victoire ou de defaite
	 * @param b si on gagne ou perd
	 * @param im a dessiner
	 */
	public void dessinerWin(Boolean b,BufferedImage im){
		if(b){
			DessinWin dessinWin;
			dessinWin = new DessinWin(this.dessinWin);
			dessinWin.dessiner(im);
			
		}else{
			DessinGameOver dessinGameOver;
			dessinGameOver = new DessinGameOver(this.dessinGameOver);
			dessinGameOver.dessiner(im);
		}
	}

}

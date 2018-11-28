package objet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import objet.coffre.CoffreDeClef;
import objet.coffre.CoffreTeleporteur;
import objet.porte.TrapeFinJeu;
import objet.teleporteur.Teleporteur;
import objet.teleporteur.TeleporteurAleatoire;
import objet.teleporteur.TeleporteurFixe;
import objet.torche.TorchePlus2;
import objet.torche.TorcheSupreme;
import plateau.Plateau;

public class Objets {
	
	private static final int TORCHE=0;
	private static final int TELEPORTEURFIXE=1;
	private static final int TELEPORTEURALEATOIRE = 2;
	private static final int COFFRETP=3;
	private static final int NBTYPEOBJET=4;
	
	private List<Objet> listeObjets;
	private int popTSPourcent;
	
	/**
	 * Construit une liste d'objets
	 * @param lO
	 * @param nbObjet nombre d'objet a creer
	 * @param p plateau dans lequel mettre les objets
	 */
	public Objets(List<Objet> lO, int nbObjet, Plateau p) {
		this.listeObjets=lO;
		popTSPourcent= 10;
		generationDObjets(nbObjet,p);
	}
	
	/**
	 * Genere les objets
	 * @param nbObjet nombre d'objet a generer
	 * @param p plateau dans lequel mettre les objets
	 */
	private void generationDObjets(int nbObjet, Plateau p) {
		Random r= new Random();
		Objet o ;
		CoffreDeClef c;
		int compt=0;
		int obj;
		int[] pos;
		pos = randPosition(p);
		c = new CoffreDeClef(pos[0],pos[1]);
		listeObjets.add(c);
		
		pos = randPosition(p);
		o = new TrapeFinJeu(pos[0],pos[1],c);
		listeObjets.add(o);
		
		while (compt<nbObjet ){
			obj=r.nextInt(NBTYPEOBJET);
			
			pos = randPosition(p);
			switch (obj){
				case TORCHE:
					obj= r.nextInt(100);
					if (obj < popTSPourcent)
						o = new TorcheSupreme(pos[0],pos[1]);
					else
						o = new TorchePlus2(pos[0],pos[1]);
					listeObjets.add(o);
					compt++;
					break;
				case TELEPORTEURFIXE:
					Teleporteur t = new TeleporteurFixe(new ArrayList<Teleporteur>(), pos[0],pos[1]);
					listeObjets.add(t);
					compt ++;
					
					pos = randPosition(p);
					Teleporteur t2 = new TeleporteurFixe(new ArrayList<Teleporteur>(),pos[0],pos[1]);
					t.addLien(t2.getNumeroDeTeleporteur());
					t2.addLien(t.getNumeroDeTeleporteur());						
					listeObjets.add(t2);
					compt ++;
					break;
				case TELEPORTEURALEATOIRE:
					Teleporteur ta = new TeleporteurAleatoire(new ArrayList<Teleporteur>(),pos[0],pos[1]);
					listeObjets.add(ta);
					compt ++;
					if (ta.getNumeroDeTeleporteur()==0){
						pos = randPosition(p);
						Teleporteur ta2 = new TeleporteurAleatoire(new ArrayList<Teleporteur>(),pos[0],pos[1]);						
						listeObjets.add(ta2);
						compt ++;
					}
					break;
				case COFFRETP:
					o = new CoffreTeleporteur(pos[0],pos[1]);
					listeObjets.add(o);
					compt++;
					break;
			}
		}
	}
	
	public List<Objet> getObjets() {
		return listeObjets;
	}
	
	/**
	 * Regarde pour chaque objet s'il y a colision avec le hero, lance l'action de l'objet si c'est le cas
	 * @param mj jeu dans lequel
	 * @param x position en X
	 * @param y position en Y
	 */
	public void collision(MonJeu mj, int x, int y) {
		for (Objet o :listeObjets){
			o.Collision(mj, x, y);
		}
	}
	
	/**
	 * Detecte la colision avec un objet et le personnage
	 * @param x position en X
	 * @param y position en Y
	 * @return s'il y a colision ou non
	 */
	public boolean collision(int x, int y) {
		boolean col= false;
		for(Objet o: listeObjets){
			if (o.getX()==x && o.getY()==y) {
				col=true;
			}
		}
		return col;
	}

	/**
	 * Donne une position dans le plateau aletoirement
	 * @param p plateau où chercher une position
	 * @return la position genere aleatoirement (couple de X;Y)
	 */
	private int[] randPosition(Plateau p) {
		int x,y;
		Random r= new Random();
		do{
		x=r.nextInt(Bibliotheque.TAILLE_TABLEAUX);
		y= r.nextInt(Bibliotheque.TAILLE_TABLEAUY);
		}while (p.collision(x, y) || collision(x, y) || (p.getSpawn().x == x && p.getSpawn().y == y));
		int i[] = {x,y};
		return i;
	}
}

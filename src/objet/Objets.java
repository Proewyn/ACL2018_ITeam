package objet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import monJeu.MonJeu;
import objet.coffre.CoffreTeleporteur;
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
	
	public Objets(List<Objet> lO, int nbObjet, Plateau p) {
		this.listeObjets=lO;
		popTSPourcent= 10;
		generationDObjets(nbObjet,p);
	}
	
	
	private void generationDObjets(int nbObjet, Plateau p) {
		Random r= new Random();
		Objet o ;
		int compt=0;
		int obj,x,y;
		while (compt<nbObjet ){
			obj=r.nextInt(NBTYPEOBJET);
			x=r.nextInt(p.taillePlateaux());
			y= r.nextInt(p.taillePlateauy());
			while (p.collision(x, y) || collision(x, y)){
				x=r.nextInt(p.taillePlateaux());
				y= r.nextInt(p.taillePlateauy());
			}
			switch (obj){
				case TORCHE:
					obj= r.nextInt(100);
					if (obj < popTSPourcent)
						o = new TorcheSupreme(x,y);
					else
						o = new TorchePlus2(x,y);
					listeObjets.add(o);
					compt++;
					break;
				case TELEPORTEURFIXE:
					Teleporteur t = new TeleporteurFixe(new ArrayList<Teleporteur>(), x, y);
					listeObjets.add(t);
					compt ++;
					
					x=r.nextInt(p.taillePlateaux());
					y= r.nextInt(p.taillePlateauy());
					while (p.collision(x, y)){
						x=r.nextInt(p.taillePlateaux());
						y= r.nextInt(p.taillePlateauy());
					}
					Teleporteur t2 = new TeleporteurFixe(new ArrayList<Teleporteur>(), x, y);
					t.addLien(t2.getNumeroDeTeleporteur());
					t2.addLien(t.getNumeroDeTeleporteur());						
					listeObjets.add(t2);
					compt ++;
					break;
				case TELEPORTEURALEATOIRE:
					Teleporteur ta = new TeleporteurAleatoire(new ArrayList<Teleporteur>(), x, y);
					listeObjets.add(ta);
					compt ++;
					if (ta.getNumeroDeTeleporteur()==0){
						x=r.nextInt(p.taillePlateaux());
						y= r.nextInt(p.taillePlateauy());
						while (p.collision(x, y)){
							x=r.nextInt(p.taillePlateaux());
							y= r.nextInt(p.taillePlateauy());
						}
						Teleporteur ta2 = new TeleporteurAleatoire(new ArrayList<Teleporteur>(), x, y);						
						listeObjets.add(ta2);
						compt ++;
					}
					break;
				case COFFRETP:
					o = new CoffreTeleporteur(x,y);
					listeObjets.add(o);
					compt++;
					break;
			}
		}
	}
	
	public List<Objet> getObjets(){
		return listeObjets;
	}
	
	public void collision(MonJeu mj, int x, int y){
		for (Objet o :listeObjets){
			o.Collision(mj, x, y);
		}
	}
	
	public boolean collision( int x, int y){
		boolean col= false;
		for(Objet o: listeObjets){
			if (o.getX()==x && o.getY()==y)
				col=true;
		}
		return col;
	}

}

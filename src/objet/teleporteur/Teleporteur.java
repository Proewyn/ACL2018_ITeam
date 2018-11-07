package objet.teleporteur;

import java.util.List;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import objet.Objet;

public abstract class Teleporteur implements Objet {
	protected static List<Teleporteur> listeTeleporteur;
    protected static int nombreTeleporteur=0;
    private int numTeleporteur;
	protected int x;
	protected int y;
	protected int lien;
	protected boolean vienDApparaitre;
	
	public Teleporteur(List<Teleporteur> l,int x ,int y) {
		this.x=x;
		this.y=y;
		this.lien=-1;
		if (listeTeleporteur==null){
			listeTeleporteur=l;
		}
		vienDApparaitre=false;		if (!listeTeleporteur.contains(this))
			listeTeleporteur.add(this);
		
		numTeleporteur=nombreTeleporteur;
		nombreTeleporteur++;
		for(int i = 0; i<nombreTeleporteur;i++){
			listeTeleporteur.get(i).majListeTeleporteur(this);
			
		}
		
	}

	@Override
	public void Collision(MonJeu mj, int x, int y) {
		if(!vienDApparaitre && this.x==x && this.y==y){
			this.action(mj);
		}else{
			if(this.x!=mj.getPj().getX() || this.y!=mj.getPj().getY() ){
				vienDApparaitre= false;
			}

		}
	}

	public void setVienDApparaitre(boolean vienDApparaitre) {
		this.vienDApparaitre = vienDApparaitre;
	}

	@Override
	public int getId() {
		return Bibliotheque.TELEPORTEUR;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getX() {
		return x;
	}

	
	@Override
	public boolean isPasTrouve() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void addLien(int t){
		this.lien=t;
	}
	
	private void majListeTeleporteur(Teleporteur t){
		if (!listeTeleporteur.contains(t))
		listeTeleporteur.add(t);
	}
	
	public int getNumeroDeTeleporteur(){
		return numTeleporteur;
	}

	public int getNbTeleporteur() {
		return nombreTeleporteur;
	}
}

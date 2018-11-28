package attaque.aDistance;

import personnage.Monstre;
import personnage.Personnage;
import monJeu.Bibliotheque;
import monJeu.MonJeu;
import moteurJeu.Commande;

public abstract class AttaqueADistance {
	
	public boolean aToucher;
	protected int x;
	protected int y;
	protected Commande direction;
	
	
	public AttaqueADistance(int x,int y,Commande dir) {
		this.x=x;
		this.y=y;
		this.direction=dir;
	}


	public boolean isaToucher() {
		return aToucher;
	}


	public void setaToucher(boolean aToucher) {
		this.aToucher = aToucher;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public void deplacement(MonJeu mj) {
		if (direction.gauche)
			x--;
		if (direction.droite)
			x++;
		if (direction.haut)	
			y--;
		if (direction.bas)
			y++;
		collision(mj);
	}
		
	public void collision(MonJeu mj){
		if (mj.getPlateau().collision(x, y)){
			aToucher = true;
		}else{
			for (Monstre m: mj.getMonstre()){
				if(m.collision(x,y)){
					degat(m);
					aToucher = true;
				}
			}
			if (mj.getPj().collision(x,y)){
				degat(mj.getPj());
				aToucher = true;
			}
		}
	}

	public int getId(){
		return Bibliotheque.ATTAQUE;
	}

	protected abstract void degat(Personnage m);
	
	

}

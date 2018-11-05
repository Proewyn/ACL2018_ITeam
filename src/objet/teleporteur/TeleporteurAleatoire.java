package objet.teleporteur;

import java.util.List;
import java.util.Random;

import monJeu.Hero;
import monJeu.MonJeu;

public class TeleporteurAleatoire extends Teleporteur {
	
	public TeleporteurAleatoire(List<Teleporteur> l, int x, int y) {
		super(l, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(MonJeu mj) {
		// TODO Auto-generated method stub
		Hero h= mj.getPj();
		Random r = new Random();
		int vers ;
		do{

			vers = r.nextInt(nombreTeleporteur);
		}while (vers==getNumeroDeTeleporteur());
		h.deplacer(listeTeleporteur.get(vers).getX(), listeTeleporteur.get(vers).getY());
		listeTeleporteur.get(vers).setVienDApparaitre(true);
	}

}

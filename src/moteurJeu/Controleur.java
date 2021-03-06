package moteurJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * @author vthomas
 */
public class Controleur implements KeyListener {

	private Commande commandeEnCours;
	private  Commande commandeARetourner; //la difference avec la commandeEnCours vient du fait qu'on veut memoriser une touche appuyee

	/**
	 * construction du controleur par defaut
	 * le controleur n'a pas de commande
	 */
	public Controleur() {
		this.commandeEnCours = new Commande();
		this.commandeARetourner = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en cours
	 * @return commande faite par le joueur
	 */
	public Commande getCommande() {
		Commande aRetourner = this.commandeARetourner;
		this.commandeARetourner = new Commande(this.commandeEnCours);
		return (aRetourner);
	}

	@Override
	public void keyPressed(KeyEvent e) {		
		switch (e.getKeyCode()) {
		// si on appuie sur 'q',commande joueur est gauche
		case KeyEvent.VK_Q:	
		case KeyEvent.VK_LEFT:
			commandeEnCours.gauche = false;
			commandeEnCours.droite = false;
			commandeEnCours.haut   = false;
			commandeEnCours.bas    = false;
			this.commandeEnCours.gauche = true;
			this.commandeARetourner.gauche = true;
			this.commandeARetourner.haut = false;
			this.commandeARetourner.bas = false;
			break;
		// si on appuie sur 'd',commande joueur est droite
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			commandeEnCours.gauche = false;
			commandeEnCours.droite = false;
			commandeEnCours.haut   = false;
			commandeEnCours.bas    = false;
			this.commandeEnCours.droite = true;
			this.commandeARetourner.droite = true;
			this.commandeARetourner.haut = false;
			this.commandeARetourner.bas = false;
			break;
		// si on appuie sur 'z',commande joueur est haut
		case KeyEvent.VK_Z:
		case KeyEvent.VK_UP:
			commandeEnCours.gauche = false;
			commandeEnCours.droite = false;
			commandeEnCours.haut   = false;
			commandeEnCours.bas    = false;
			this.commandeEnCours.haut = true;
			this.commandeARetourner.haut = true;
			this.commandeARetourner.gauche = false;
			this.commandeARetourner.droite = false;
			break;
		// si on appuie sur 's',commande joueur est bas
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			commandeEnCours.gauche = false;
			commandeEnCours.droite = false;
			commandeEnCours.haut   = false;
			commandeEnCours.bas    = false;
			this.commandeEnCours.bas = true;
			this.commandeARetourner.bas = true;
			this.commandeARetourner.gauche = false;
			this.commandeARetourner.droite = false;
			break;
		case KeyEvent.VK_SPACE:
			this.commandeEnCours.attaque = true;
			break;
		case KeyEvent.VK_P:
			this.commandeEnCours.pause = !commandeEnCours.pause;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Q:		
		case KeyEvent.VK_LEFT:
			this.commandeEnCours.gauche = false;
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			this.commandeEnCours.droite = false;
			break;
		case KeyEvent.VK_Z:
		case KeyEvent.VK_UP:
			this.commandeEnCours.haut = false;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			this.commandeEnCours.bas = false;
			break;
		case KeyEvent.VK_SPACE:
			this.commandeEnCours.attaque = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}

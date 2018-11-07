package moteurJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class Controleur implements KeyListener {

	/**
	 * commande en cours
	 */
	private Commande commandeEnCours;
	/**
	 * commande a retourner la difference avec la commandeencours vient du fait
	 * qu'on veut memoriser une touche appuyee
	 */
	private  Commande commandeARetourner;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public Controleur() {
		this.commandeEnCours = new Commande();
		this.commandeARetourner = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Commande getCommande() {
		Commande aRetourner = this.commandeARetourner;
		this.commandeARetourner = new Commande(this.commandeEnCours);
		return (aRetourner);
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		commandeEnCours.gauche = false;
		commandeEnCours.droite = false;
		commandeEnCours.haut   = false;
		commandeEnCours.bas    = false;
		
		switch (e.getKeyCode()) {
		// si on appuie sur 'q',commande joueur est gauche
		case KeyEvent.VK_Q:	
		case KeyEvent.VK_LEFT:
			this.commandeEnCours.gauche = true;
			this.commandeARetourner.gauche = true;
			this.commandeARetourner.haut = false;
			this.commandeARetourner.bas = false;
			break;
		// si on appuie sur 'd',commande joueur est droite
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			this.commandeEnCours.droite = true;
			this.commandeARetourner.droite = true;
			this.commandeARetourner.haut = false;
			this.commandeARetourner.bas = false;
			break;
		// si on appuie sur 'z',commande joueur est haut
		case KeyEvent.VK_Z:
		case KeyEvent.VK_UP:
			this.commandeEnCours.haut = true;
			this.commandeARetourner.haut = true;
			this.commandeARetourner.gauche = false;
			this.commandeARetourner.droite = false;
			break;
		// si on appuie sur 's',commande joueur est bas
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			this.commandeEnCours.bas = true;
			this.commandeARetourner.bas = true;
			this.commandeARetourner.gauche = false;
			this.commandeARetourner.droite = false;
			break;
		}
	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
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
		}
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}

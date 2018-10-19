package moteurJeu;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import monJeu.MonJeu;
import moteurJeu.Menu;


/**
 * cree une interface graphique avec son controleur et son afficheur
 * @author Graou
 *
 */
public class InterfaceGraphique implements Observer {

	/**
	 * le Panel lie a la JFrame
	 */
	private PanelDessin panel;
	
	/**
	 * le controleur lie a la JFrame
	 */
	private Controleur controleur;
	
	/**
	 * la construction de l'interface grpahique
	 * - construit la JFrame
	 * - construit les Attributs
	 * 
	 * @param afficheurUtil l'afficheur a utiliser dans le moteur
	 * 
	 */
	public InterfaceGraphique(DessinJeu afficheurUtil,int x,int y, MonJeu mj)
	{
		mj.addObserver(this);
		
		//creation JFrame
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creation panel
		this.panel=new PanelDessin(x, y,afficheurUtil);
		f.setContentPane(this.panel);
		
		//creation menu
		Menu menuPrincipal = new Menu(mj);
		f.setJMenuBar(menuPrincipal);
		
		//ajout du controleur
		Controleur controlleurGraph=new Controleur();
		this.controleur=controlleurGraph;
		this.panel.addKeyListener(controlleurGraph);	
		
		//recuperation du focus
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}
	
	
	/**
	 * retourne le controleur de l'affichage construit
	 * @return
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/**
	 * demande la mise a jour du dessin
	 */
	public void dessiner() {
		this.panel.dessinerJeu();	
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}

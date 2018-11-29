package moteurJeu;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import monJeu.MonJeu;

/**
 * cree une interface graphique avec son controleur et son afficheur
 * @author Graou
 */
public class InterfaceGraphique implements Observer {

	private MonJeu jeu;
	private PanelDessin panel;
	private PanelStat stat;
	private Controleur controleur;
	
	/**
	 * Constructeur de l'Interface Graphique
	 * @param afficheurUtil l'afficheur a utiliser dans le moteur
	 * @param x taille en X
	 * @param y taille en Y
	 * @param mj jeu a afficher
	 */
	public InterfaceGraphique(DessinJeu afficheurUtil, int x, int y, MonJeu mj)
	{
		jeu = mj;
		
		//creation JFrame
		JFrame f = new JFrame("Escaping the Maze");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable( false );
		
		//creation panel
		JPanel fenetre = new JPanel();
		
		this.panel = new PanelDessin(x, y,afficheurUtil);
		this.stat = new PanelStat(jeu);
		
		fenetre.add(panel, BorderLayout.WEST);
		fenetre.add(stat, BorderLayout.EAST);
		f.setContentPane(fenetre);
		
		//ajout du controleur
		Controleur controlleurGraph=new Controleur();
		controleur=controlleurGraph;
		fenetre.addKeyListener(controlleurGraph);	
		
		//recuperation du focus
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
		
		jeu.addObserver(this);
	}
	
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
		if (jeu.isEnPause())
			this.stat.pause.setText("PAUSE!!!!!!!!!!!");
		else{
			this.stat.hp.setText("Point de vie : " + jeu.getPj().getHp());
			this.stat.pause.setText("");
		}
	}

}

package moteurJeu;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import monJeu.MonJeu;
import moteurJeu.Menu;


/**
 * cree une interface graphique avec son controleur et son afficheur
 * @author Graou
 *
 */
public class InterfaceGraphique implements Observer {

	private MonJeu jeu;
	/**
	 * le Panel lie a la JFrame
	 */
	private PanelDessin panel;
	private PanelStat stat;
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
		jeu = mj;
		
		//creation JFrame
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable( false );
		
		//creation panel
		JPanel fenetre = new JPanel();
		
		this.panel = new PanelDessin(x, y,afficheurUtil);
		//f.setContentPane(this.panel);
		
		this.stat = new PanelStat(jeu);
		
		fenetre.add(panel, BorderLayout.WEST);
		fenetre.add(stat, BorderLayout.EAST);
		f.setContentPane(fenetre);
		
		//creation menu
		Menu menuPrincipal = new Menu(jeu);
		f.setJMenuBar(menuPrincipal);
		
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
		this.stat.hp.setText("Point de vie : " + jeu.getPj().getHp());
	}

}

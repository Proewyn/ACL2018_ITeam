package moteurJeu;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import monJeu.MonJeu;

@SuppressWarnings("serial")
public class PanelStat extends JPanel{
	
	protected JLabel hp;
	
	/**
	 * Cree un Panel pour l'affichage de diverses statistiques
	 * @param jeu donnant les informations au Panel
	 */
	public PanelStat(MonJeu jeu) {
		super(new GridLayout(5, 1));
		this.setPreferredSize(new Dimension(150, 100));
		hp = new JLabel("Point de vie : " + jeu.getPj().getHp());
		add(new JLabel("Player 1"));
		add(hp);
	}

}

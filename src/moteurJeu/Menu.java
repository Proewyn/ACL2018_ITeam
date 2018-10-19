package moteurJeu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import monJeu.MonJeu;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	
	public Menu(MonJeu mj) {
		JMenu menu = new JMenu("Fichier");
		JMenuItem jmopen = new JMenuItem("Ouvrir fichier");
		jmopen.addActionListener(new EcouteurOpen(mj));
		menu.add(jmopen);
		this.add(menu);
	}

}

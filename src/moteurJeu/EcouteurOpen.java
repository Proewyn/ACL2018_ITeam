package moteurJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import monJeu.MonJeu;

public class EcouteurOpen implements ActionListener {

	private MonJeu mj;
	
	public EcouteurOpen(MonJeu mj) {
		this.mj = mj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			try {
				mj.initLabyFichier();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	*/
}

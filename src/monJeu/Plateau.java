package monJeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;

import Generateur.*;

public class Plateau {

	private Case[][] laby;
	
	public Plateau (){
		initLabyGenerateur();
	}
	
	private void initLaby(int taillex,int tailley) {
				
		laby = new Case[taillex][tailley];
		for (int i=0;i<tailley;i++){
			laby[0][i]=new Mur(true);
			laby[taillex-1][i]=new Mur(true);
		}
		
		for (int i=1;i<taillex-1;i++){
			laby[i][0]=new Mur(true);
			for (int j=1;j<tailley-1;j++){
				laby[i][j]=new Sol();
			}
			laby[i][tailley-1]=new Mur(true);
		}
		laby[4][6]=new Mur();
		laby[5][5]=new Mur();
		laby[4][4]=new Mur();
		laby[3][5]=new Mur();
	}
	

	public Case[][] getLaby(){
		return laby;
	}
	
	public boolean collision(int x, int y) {
		if(x < 0 || y < 0)
			return false;
		return !laby[x][y].isTraversable();
	}

	public int taillePlateaux() {
		// TODO Auto-generated method stub
		return laby.length;
	}

	public int taillePlateauy() {
		// TODO Auto-generated method stub
		return laby[0].length;
	}

	public boolean isMur(int i, int j) {
		// TODO Auto-generated method stub
		
		return laby[i][j].getId() == Bibliotheque.MUR;
	}
	
	public void printLab(){
		for (int i = 0; i < laby.length; i++) {
			for (int j = 0; j < laby[0].length; j++) {
				System.out.print(laby[i][j].getId()+" ");
			}
			System.out.println();
		}
	}
	
	public void initLabyFichier() throws FileNotFoundException {
		JFileChooser jf = new JFileChooser();
		int returnVal = jf.showOpenDialog(jf);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			FileReader flot;
			BufferedReader flotFiltre;
			File file = jf.getSelectedFile();
			flot = new FileReader(file.getAbsolutePath());
			flotFiltre = new BufferedReader(flot);
			Scanner sc = new Scanner(flotFiltre);
			while (sc.hasNext()){
				String s = sc.next();
				if (s.charAt(0)=='N') {
					
				}
				if (s.charAt(0)=='R') {

				}
			}
			sc.close();
		}
	}
	
	public void initLabyGenerateur() {
		AbstractGenerateur gen;
		switch (Bibliotheque.GENERATEUR) {
		case 1:
			gen = new GenerateurWormHole();
			break;
		case 2:
			gen = new GenerateurWormHoleImparfait();
			break;
		case 3:
			gen = new GenerateurCancer();
			break;
		case 4:
			gen = new GenerateurFusion();
			break;
		default:
			gen = new GenerateurWormHole();
			break;
		}
		
		laby = gen.getLab();
	}
	
}

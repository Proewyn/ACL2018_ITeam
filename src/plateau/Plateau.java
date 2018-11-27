package plateau;

import generateur.*;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;

import monJeu.Bibliotheque;
import monJeu.DessinMonJeu;
import monJeu.MonJeu;
import moteurJeu.MoteurGraphique;


public class Plateau {

	private Case[][] laby;
	
	public Plateau (){
		initLabyGenerateur();
	}
	
	

	public Point getSpawn(){
		Point p = new Point(10,10);
		for (int i = 0; i < laby.length; i++) {
			for (int j = 0; j < laby[0].length; j++) {
				if(laby[i][j].getId() == Bibliotheque.SPAWN) {
					p = new Point(i,j);
				}
			}
		}
		
		return p;
	}
	
	public Case[][] getLaby(){
		return laby;
	}
		
	public void setLaby(Case[][] laby) {
		this.laby = laby;
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
	
	public void initLabyFichier(MonJeu jeu) throws FileNotFoundException, InterruptedException {
		int pos = 0, colonne = -1, ligne = 0;
		boolean correct = true;
		Case[][] labyrinthe;
		JFileChooser jf = new JFileChooser();
		int returnVal = jf.showOpenDialog(jf);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			FileReader flot, flotVerif;
			BufferedReader flotFiltre, flotFiltreVerif;
			File file = jf.getSelectedFile();
			flot = new FileReader(file.getAbsolutePath());
			flotVerif = new FileReader(file.getAbsolutePath());
			flotFiltre = new BufferedReader(flot);
			flotFiltreVerif = new BufferedReader(flotVerif);
			Scanner sc = new Scanner(flotFiltre);
			Scanner scVerif = new Scanner(flotFiltreVerif);
			//On vérifie que le fichier est correct (Un rectangle)
			while (scVerif.hasNext()){
				String s = scVerif.next();
				pos = 0;
				while (pos < s.length()) {
					pos++;
				}
				if (colonne < 0 ) {
					colonne = pos;
				}
				if (colonne != pos) {
					correct = false;
				}
				ligne++;
			}
			//On crée le labirynthe à partir du fichier vérifié
			if (correct) {
				Bibliotheque.setTaillePlateauX(colonne);
				Bibliotheque.setTaillePlateauY(ligne);
				labyrinthe = new Case[colonne+1][ligne+1]; 
				ligne = 0;
				while (sc.hasNext()){
					String s = sc.next();
					pos = 0;
					while (pos < s.length()) {
						if (s.charAt(pos)=='0') {
							labyrinthe[ligne][pos] = new Mur();
						}
						if (s.charAt(pos)=='1') {
							labyrinthe[ligne][pos] = new Sol();
						}
						pos++;
					}
					System.out.println(ligne);
					ligne++;
				}
				sc.close();
				scVerif.close();
				this.setLaby(labyrinthe);
			}
		}
		jeu = new MonJeu(this);
		DessinMonJeu dessinJeu = new DessinMonJeu(jeu);
		MoteurGraphique moteur = new MoteurGraphique(jeu, dessinJeu);
		moteur.lancerJeu();
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

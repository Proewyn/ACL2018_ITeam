package attaque;

import java.util.List;

import monJeu.MonJeu;
import attaque.aDistance.AttaqueADistance;

public class LesAttaques {

	private List<AttaqueADistance> attaques;
	
	public LesAttaques(List<AttaqueADistance> a) {
		attaques = a;
		
	}
	
	public void deplacement(MonJeu mj){
		for (AttaqueADistance ad : attaques){
			
			ad.deplacement(mj);
		}
		cleanAttaque();
	}

	private void cleanAttaque() {
		int i = 0;
		while (i < attaques.size()) {
			if (attaques.get(i).isaToucher()) {
				attaques.remove(i);
			}
			else {
				i++;
			}
		}
	}
	
	public void addAttaque(AttaqueADistance a){
		attaques.add(a);
	}
	public List<AttaqueADistance> getAttaques(){
		return attaques;
	}

	public void collision(MonJeu mj) {
		for (AttaqueADistance a : attaques){
			a.collision(mj);
		}
		
	}

}

package objet.torche;
import personnage.Hero;
import monJeu.MonJeu;

public class TorchePlus2 extends Torche {
	
	public TorchePlus2(int x,int y) {
		super(x,y);
	}

	@Override
	public void action(MonJeu mj) {
		Hero h = mj.getPj();
		h.setVision(h.getVision()+2);
		pasTrouve=false;
	}

}

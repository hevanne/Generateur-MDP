package controleur;

import ihm.*;
import metier.*;

public class Controleur{

	FrameMDP ihm;
	MDP metier;

	public Controleur(){
		this.ihm = new FrameMDP(this);
		this.metier = new MDP(0, false, false, this);
	}

	public String generer(int nbCar, boolean carSpeciaux, boolean chiffre){
		if(nbCar <= 0 || nbCar > 30)
			return metier.generer(10, carSpeciaux, chiffre);

		return metier.generer(nbCar, carSpeciaux, chiffre);
	}

	public static void main(String[] args){
		new Controleur();
	}
}
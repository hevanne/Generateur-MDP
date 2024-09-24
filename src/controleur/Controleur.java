package controleur;

import ihm.*;
import metier.*;

public class Controleur{

	FrameMDP ihm;
	MDP metier;

	public Controleur(){
		this.ihm = new FrameMDP();
	}

	public String generer(int nbCar, boolean carSpeciaux, boolean chiffre){
		return metier.generer(nbCar, carSpeciaux, chiffre);
	}

	public static void main(String[] args){
		new Controleur();
	}
}
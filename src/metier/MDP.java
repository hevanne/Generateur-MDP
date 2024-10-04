package metier;

import controleur.Controleur;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MDP{

	private static List<Character> lstLettresMaj  = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
	private static List<Character> lstLettresMin  = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
	private static List<Integer>   lstChiffres    = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
	private static List<Character> lstCarSpeciaux = new ArrayList<>(Arrays.asList('!', '?', '"', '&', '#', '@', '(', ')', '[', ']', '$', '€', '|', '^', '%'));

	private int     nbCar;
	private boolean carSpeciaux;
	private boolean chiffre;
	private String  motDePasse;

	Controleur c;

	public MDP(int nbCar, boolean carSpeciaux, boolean chiffre, Controleur c){
		this.nbCar       = nbCar;
		this.carSpeciaux = carSpeciaux;
		this.chiffre     = chiffre;

		this.c = c;

		this.motDePasse = generer(nbCar, carSpeciaux, chiffre);
	}

	public String generer(int nbCar, boolean carSpeciaux, boolean chiffre){
		Collections.shuffle(MDP.lstLettresMaj);
		Collections.shuffle(MDP.lstLettresMin);
		Collections.shuffle(MDP.lstCarSpeciaux);
		Collections.shuffle(MDP.lstChiffres);

		int nbHasard = 0;
		String mdp = "";

		if(carSpeciaux & chiffre){
			for(int i = 1; i <= nbCar; i++){
				nbHasard = nbHasard(4);

				switch (nbHasard){
					case 1: 
						mdp += lstLettresMaj.get(0);
						lstLettresMaj.remove(0);
						break;
					case 2: 
						mdp += lstLettresMin.get(0);
						lstLettresMin.remove(0);
						break;
					case 3: 
						mdp += lstCarSpeciaux.get(0);
						lstCarSpeciaux.remove(0);
						break;
					case 4: 
						mdp += lstChiffres.get(0);
						lstChiffres.remove(0);
						break;
					default: break;
				}
			}
		}

		if(!carSpeciaux & chiffre){
			for(int i = 1; i <= nbCar; i++){
				nbHasard = nbHasard(3);

				switch (nbHasard){
					case 1: 
						mdp += lstLettresMaj.get(0);
						lstLettresMaj.remove(0);
						break;
					case 2: 
						mdp += lstLettresMin.get(0);
						lstLettresMin.remove(0);
						break;
					case 3: 
						mdp += lstChiffres.get(0);
						lstChiffres.remove(0);
						break;
					default: break;
				}
			}
		}

		if(carSpeciaux & !chiffre){
			for(int i = 1; i <= nbCar; i++){
				nbHasard = nbHasard(3);

				switch (nbHasard){
					case 1: 
						mdp += lstLettresMaj.get(0);
						lstLettresMaj.remove(0);
						break;
					case 2: 
						mdp += lstLettresMin.get(0);
						lstLettresMin.remove(0);
						break;
					case 3: 
						mdp += lstCarSpeciaux.get(0);
						lstCarSpeciaux.remove(0);
						break;
					default: break;
				}
			}
		}

		if(!carSpeciaux & !chiffre){
			for(int i = 1; i <= nbCar; i++){
				nbHasard = nbHasard(2);

				switch (nbHasard){
					case 1: 
						mdp += lstLettresMaj.get(0);
						lstLettresMaj.remove(0);
						break;
					case 2: 
						mdp += lstLettresMin.get(0);
						lstLettresMin.remove(0);
						break;
					default: break;
				}
			}
		}

		return mdp;
	}

	private int nbHasard(int nb){ return (int) (Math.random() * (nb)) + 1; }

	public String toString(){ return motDePasse; }
}
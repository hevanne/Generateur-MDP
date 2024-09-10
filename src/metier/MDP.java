package metier;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MDP{

	private static List<Character> lstLettresMaj;
	private static List<Character> lstLettresMin;
	private static List<Integer>   lstChiffres;
	private static List<Character> lstCarSpeciaux;

	private int     nbCar;
	private boolean carSpeciaux;
	private boolean chiffre;
	private String  motDePasse;

	public MDP(int nbCar, boolean carSpeciaux, boolean chiffre ){
		MDP.lstLettresMaj  = new ArrayList<Character>();
		MDP.lstLettresMin  = new ArrayList<Character>();
		MDP.lstChiffres    = new ArrayList<Integer>();
		MDP.lstCarSpeciaux = new ArrayList<Character>();

		for(char lettre = 'A'; lettre <= 'Z'; lettre++)
			lstLettresMaj.add(lettre);

		for(char lettre = 'a'; lettre <= 'z'; lettre++)
			lstLettresMin.add(lettre);

		for(int nb = 0; nb <= 9; nb++)
			lstChiffres.add(nb);

		lstCarSpeciaux.addAll(Arrays.asList('!', '?', '"', '&', '#', '@', '(', ')', '[', ']', '$', '€', '|', '^', '%'));

		if(nbCar <= 0 || nbCar > 30)
			nbCar = 10;
		else
			this.nbCar       = nbCar;
		
		this.carSpeciaux = carSpeciaux;
		this.chiffre     = chiffre;

		motDePasse = generer(nbCar, carSpeciaux, chiffre);
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
				nbHasard = nbHasard4();

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
				nbHasard = nbHasard3();

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
				nbHasard = nbHasard3();

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
				nbHasard = nbHasard2();

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

	private int nbHasard2(){ return (int) (Math.random() * (2)) + 1; }
	private int nbHasard3(){ return (int) (Math.random() * (3)) + 1; }
	private int nbHasard4(){ return (int) (Math.random() * (4)) + 1; }

	public String toString(){ return motDePasse; }

	public static void main(String[] args) {
		MDP mdp = new MDP(15, true, true);

		System.out.println(mdp);
	}
}
package metier;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MDP{

	private static List<Character> lstLettres;
	private static List<Integer>   lstChiffres;
	private static List<Character> lstCarSpeciaux;

	private int     nbCar;
	private boolean carSpeciaux;
	private boolean chiffre;

	public MDP(int nbCar, boolean carSpeciaux, boolean chiffre ){
		MDP.lstLettres     = new ArrayList<Character>();
		MDP.lstChiffres    = new ArrayList<Integer>();
		MDP.lstCarSpeciaux = new ArrayList<Character>();

		for(char lettre = 'A'; lettre <= 'Z'; lettre++)
			lstLettres.add(lettre);
		for(int nb = 0; nb <= 9; nb++)
			lstChiffres.add(nb);
		lstCarSpeciaux.addAll(Arrays.asList('!', '?', '"', '&', '#', '@', '(', ')', '[', ']', '$', '€', '|', '^', '%'));

		this.nbCar       = nbCar;
		this.carSpeciaux = carSpeciaux;
		this.chiffre     = chiffre;
	}

	public void afficherListes(){
		System.out.println(lstLettres);
		System.out.println(lstChiffres);
		System.out.println(lstCarSpeciaux);
	}

	public static void main(String[] args) {
		MDP mdp = new MDP(0, false, false);

		mdp.afficherListes();
	}
}
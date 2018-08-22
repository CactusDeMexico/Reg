package controleur;

import vue.VueConnexion;
import vue.VueGeneral;

public class Main {

	private static VueConnexion uneConnexion;
	private static VueGeneral uneGen;
	
	public static void rendreVisible (boolean action)
	{
		Main.uneConnexion.setVisible(action);
		
	}
	public static void main(String[] args) {
		Main.uneConnexion = new VueConnexion();
		//Main.uneGen = new VueGeneral(Nom);
		
	}

}

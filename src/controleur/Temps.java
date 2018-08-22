package controleur;

import java.sql.Date;

public class Temps {
	private static int nbChampsTemps = 3;
	
	private int idTemps ; 
	private String datedebut;
	private String datefin;

	
	
	public Temps (int idTemps, String datedebut,String datefin)
	{
		this.idTemps = idTemps; 
		this.datedebut=datedebut;
		this.datefin = datefin; 
		 // INSERT INTO Temps 
	}
	
	public Temps ( String datedebut,String datefin)
	{
		this.idTemps = 0;
		this.datedebut=datedebut;
		this.datefin = datefin; 
		 // INSERT INTO Temps 
	}

	public static int getNbChampsTemps() {
		return nbChampsTemps;
	}

	public static void setNbChampsTemps(int nbChampsTemps) {
		Temps.nbChampsTemps = nbChampsTemps;
	}

	public int getIdTemps() {
		return idTemps;
	}

	public void setIdTemps(int idTemps) {
		this.idTemps = idTemps;
	}

	public String getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}

	public String getDatefin() {
		return datefin;
	}

	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	
}

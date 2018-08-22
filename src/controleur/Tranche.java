package controleur;



public class Tranche  {
	private static int nbChampsTranche = 2;
	private int idTranche ; 
	private int Palier;
	
	
	
	public Tranche (int idTranche, int Palier)
	{
		this.idTranche = idTranche; 
		this.Palier=Palier;
	 
		 // INSERT INTO Tranche 
	}
	
	public Tranche ( int Palier)
	{
		this.idTranche = 0; 
		this.Palier=Palier;
	 
		 // INSERT INTO Tranche 
	}

	public static int getNbChampsTranche() {
		return nbChampsTranche;
	}

	public static void setNbChampsTranche(int nbChampsTranche) {
		Tranche.nbChampsTranche = nbChampsTranche;
	}

	public int getIdTranche() {
		return idTranche;
	}

	public void setIdTranche(int idTranche) {
		this.idTranche = idTranche;
	}

	public int getPalier() {
		return Palier;
	}

	public void setPalier(int tranche) {
		Palier = Palier;
	}
	

}
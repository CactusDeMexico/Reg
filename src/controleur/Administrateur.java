package controleur;

public class Administrateur {
private static int nbChampsAdministrateurs = 3;
	
	private int idAdmin; 
	private String nom,password;
	
	public Administrateur ()
	{
		this.idAdmin=0; 
		this.nom = this.password =""; 
	}
	public Administrateur (int idAdmin, String nom, String password)
	{
		this.idAdmin = idAdmin; 
		this.nom = nom; 
		this.password = password; 
	}
	public static int getNbChampsAdministrateurs() {
		return nbChampsAdministrateurs;
	}
	public static void setNbChampsAdministrateurs(int nbChampsAdministrateurs) {
		Administrateur.nbChampsAdministrateurs = nbChampsAdministrateurs;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

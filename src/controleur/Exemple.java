package controleur;

public class Exemple
{
	private static int nbChampsexemples = 5;
	private String Nom,Nomimage,DateDebut,Url;
	private int Quantite ;
	
	public Exemple(String Nom,String DateDebut, int Quantite,String Nomimage,String Url)
	{
		this.Nom=Nom;
		this.Nomimage=Nomimage;
		this.DateDebut=DateDebut;
		this.Quantite=Quantite;
		this.Url=Url;
	}
	public Exemple(String Nom,String DateDebut, String Nomimage,String Url)
	{
		this.Nom=Nom;
		this.Nomimage=Nomimage;
		this.DateDebut=DateDebut;
		this.Quantite=0;
		this.Url=Url;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public static int getNbChampsexemples() {
		return nbChampsexemples;
	}
	public static void setNbChampsexemples(int nbChampsexemple) {
		Exemple.nbChampsexemples = nbChampsexemple;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getNomimage() {
		return Nomimage;
	}
	public void setNomimage(String nomimage) {
		Nomimage = nomimage;
	}
	public String getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut(String dateDebut) {
		DateDebut = dateDebut;
	}
	public int getQuantite() {
		return Quantite;
	}
	public void setQuantite(int quantite) {
		Quantite = quantite;
	}
	
}

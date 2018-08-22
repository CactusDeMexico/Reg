package controleur;

import javax.swing.ImageIcon;

public class Media {
	private static int nbChampsMedia = 5;
	private String nom,url;
	private int idMedia ; 
	
	
	
	
	public Media (int idMedia, String nom,String url)
	{
		this.idMedia = idMedia; 
		this.nom=nom;
		this.url=url;
	 
		 // INSERT INTO Media 
	}
	
	public Media ( String nom,String url)
	{
		this.idMedia = 0; 
		this.nom=nom;
		this.url=url;
	 
		 // INSERT INTO Media 
	}

	public static int getNbChampsMedia() {
		return nbChampsMedia;
	}

	public static void setNbChampsMedia(int nbChampsMedia) {
		Media.nbChampsMedia = nbChampsMedia;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdMedia() {
		return idMedia;
	}

	public void setIdMedia(int idMedia) {
		this.idMedia = idMedia;
	}
	


}
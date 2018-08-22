package controleur;

public class Produit {
	private static int nbChampsProduits = 7;
	
	private int idProduit ; 
	private float prix;
	private String nom, type,description;
	private int quantite;
	private int AlerteQuantite;
	
	public Produit()
	{
		this.idProduit = 0; 
		this.prix=this.quantite=0;
		this.nom =this.type=this.description =""; 
	this.AlerteQuantite=0;
		
	}
	public Produit (int idProduit, float prix, String nom,String type, String description, int quantite,int AlerteQuantite)
	{
		this.idProduit = idProduit; 
		this.prix=prix;
		this.nom = nom; 
		this.type=type;
		this.description = description; 
		this.quantite=quantite;
		this.AlerteQuantite=AlerteQuantite;
		 // INSERT INTO produit 
	}
	
	public Produit ( float prix, String nom,String type,  String description,int quantite,int AlerteQuantite  )
	{
		this.idProduit = 0; 
		this.prix=prix;
		this.nom = nom; 
		this.type=type;
		this.description = description; 
		this.quantite=quantite;
		this.AlerteQuantite=AlerteQuantite;
		 // INSERT INTO produit 
	}
	
	
	public int getAlerteQuantite() {
		return AlerteQuantite;
	}
	public void setAlerteQuantite(int alerteQuantite) {
		AlerteQuantite = alerteQuantite;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int getNbChampsProduits() {
		return nbChampsProduits;
	}
	public static void setNbChampsProduits(int nbChampsProduits) {
		Produit.nbChampsProduits = nbChampsProduits;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}

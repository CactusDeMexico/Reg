package controleur;

public class Complet 
{
	private static int nbChampsComplet = 14;
	private String nomMedia,url;
	private int idMedia ; 
	private int idTemps ; 
	private String datedebut;
	private String datefin;
	
	private int idTranche ;
	private int palier;
	 
	private int idProduit ; 
	private float prix;
	private String nom, type,description;
	private int quantite;
	
	public Complet (int idMedia, String nomMedia,String url,
					int idTemps, String datedebut,String datefin,
					int idTranche, int palier,
					int idProduit, float prix, String nom,String type,String description,  int quantite )
		{
			this.idMedia = idMedia; 
			this.nomMedia=nomMedia;
			this.url=url;
			this.idTemps = idTemps; 
			this.datedebut=datedebut;
			this.datefin = datefin; 
			this.idTranche = idTranche; 
			this.palier=palier;
			this.idProduit = idProduit; 
			
			this.prix=prix;
			this.nom = nom;
			this.type=type;
			this.description = description; 
			this.quantite=quantite;
		 
		 
			
		}public Complet ( String nomMedia,String url,
				 String datedebut,String datefin,
				 int palier,
				 float prix, String nom,String type,  String description, int quantite)
	{
		this.idMedia = 0; 
		this.nomMedia=nomMedia;
		this.url=url;
		this.idTemps = 0; 
		this.datedebut=datedebut;
		this.datefin = datefin; 
		this.idTranche = 0; 
		this.palier=palier;
		this.idProduit = 0; 
		
		this.prix=prix;
		this.nom = nom; 
		this.type=type;
		this.description = description; 
		this.quantite=quantite;
	 
	 
		
	}
	
	public int getIdTranche() {
		return idTranche;
	}
	public void setIdTranche(int idTranche) {
		this.idTranche = idTranche;
	}
	public int getPalier() {
		return palier;
	}
	public void setPalier(int palier) {
		this.palier = palier;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public static int getNbChampsComplet() {
		return nbChampsComplet;
	}
	public static void setNbChampsMedia(int nbChampsMedia) {
		Complet.nbChampsComplet = nbChampsMedia;
	}
	public String getNomMedia() {
		return nomMedia;
	}
	public void setNomMedia(String nomMedia) {
		this.nomMedia = nomMedia;
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
	public int getpalier() {
		return palier;
	}
	public void setpalier(int palier) {
		this.palier = palier;
	}
	public int getidTranche() {
		return idTranche;
	}
	public void setidTranche(int idTranche) {
		this.idTranche = idTranche;
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

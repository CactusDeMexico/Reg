package modele;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.jdbc.CallableStatement;

import controleur.Administrateur;
import controleur.Complet;
import controleur.Exemple;
import controleur.Media;
import controleur.Produit;
import controleur.Temps;
import controleur.Tranche;


public class Modele { 
	//Connexion a un compte Admin
	public static  String verifConnexion (String login, String mdp)
	{
		//Administrateur UnAdministrateur = null;
		
		String requete = "SELECT count(*) as nb,Nom FROM Administrateur " +
				" WHERE nom ='" + login + "' AND password ='"+mdp+"' ; ";
		String Nom=""; 
		Bdd uneBdd = new Bdd ("localhost","regroup", "root",""); 
		try{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			
			if (unRes.next())
			{	//System.out.println("oui");
				Nom = unRes.getString("Nom"); 
				
		int nb = unRes.getInt("nb");
		if (nb==0) Nom =""; 
		//System.out.println(Nom);
			}
			unRes.close(); 
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch( SQLException exp)
		{
			System.out.println("Erreur : "+ requete);
			exp.printStackTrace();
		}
		
		return Nom;
	}
/*************************************PRODUIT Procedure************************************/
/*   {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
      {call <procedure-name>[(<arg1>,<arg2>, ...)]}
      
      create procedure NameOfYourProcedureHere
as
begin

    insert into custlogin(custusename, custpassword) 
        values ('','') -- put values here (from parameters?)

    insert into custinfo(custid, custfirstname, custlastname, custaddress)
        values (SCOPE_IDENTITY(), '', '', '')  -- put other values here (from parameters?)

end
 * */
	
	
	
/*************************************PRODUIT************************************/
	public static ArrayList<Produit> selectAllProduits ()
	{
		ArrayList<Produit> lesProduits = new ArrayList<Produit>(); 
		String requete ="Select * from Produit ;"; 
		Bdd uneBdd = new Bdd("localhost", "regroup", "root", ""); 
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes  = unStat.executeQuery(requete); 
			while (unRes.next())
			{
				lesProduits.add(new Produit (unRes.getInt("idProduit"),
						 unRes.getFloat("prix"),
						 unRes.getString("nom"),
						 unRes.getString("type"),
						 unRes.getString("description"),
						 unRes.getInt("quantite"),
						 unRes.getInt("AlerteQuantite")
						 ));
			}
			unStat.close(); 
			unRes.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesProduits;
	}
	
	public static void insertProduit (Produit unProduit)
	{
		String requete = "INSERT INTO Produit(prix,nom,type,description,quantite,IdTemps,IdTranche,AlerteQantite) VALUES ( '" + 
				unProduit.getPrix()+"','"+
				unProduit.getNom() +"','"+
				unProduit.getType() +"','"+
				unProduit.getQuantite()+"','"+ 
				unProduit.getDescription()+"',@idTemps,@idTranche "+
				unProduit.getAlerteQuantite()+") ;"+
				" SET @idproduit := (SELECT LAST_INSERT_ID() ); ";
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void deleteProduit (Produit unProduit)
	{
		String requete = "delete from Produit where idProduit =" +
						unProduit.getIdProduit()+"; ";
		
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	public static void updateProduit (Produit unProduit)
	{
		String requete = "update Produit " +
				" set prix ='" + unProduit.getPrix() +
				"', nom ='"+ unProduit.getNom() +
				"', description ='"+ unProduit.getDescription()+
				"', type ='"+ unProduit.getType()+
				"', quantite ='"+ unProduit.getQuantite()+
				"', AlerteQquantite ='"+ unProduit.getAlerteQuantite()+
				"' where idProduit =" + unProduit.getIdProduit()+"; ";
		
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	
}
	/*
	 *  "INSERT INTO produit ( prix, nom, quantite,description) 
                        VALUES ('20.5','cable', '18', 'RJ45');

     


                        //recuper le dernier id pour envoyer la requette 
      SELECT IdProduit FROM produit WHERE nom ='this.nom' and description ='this.description'";
	  INSERT INTO user (adresse, email, username,telephone, password, idpersonne)
                        VALUES('$adresse', '$email', '$username','$telephone', '$password','$idpersonne')";
      $resultat = mysqli_fetch_assoc($tab);
      $idpersonne = $resultat['IdPersonne'];
      $insertion_2 = "INSERT INTO user (adresse, email, username,telephone, password, idpersonne)
                        VALUES('$adresse', '$email', '$username','$telephone', '$password','$idpersonne')";
	 */
/******************** Temps**********************/	
	public static ArrayList<Temps> selectAllTemps ()
	{
		ArrayList<Temps> lesTemps = new ArrayList<Temps>(); 
		String requete ="Select * from Temps ;"; 
		Bdd uneBdd = new Bdd("localhost", "regroup", "root", ""); 
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes  = unStat.executeQuery(requete); 
			while (unRes.next())
			{
				lesTemps.add(new Temps (unRes.getInt("idTemps"),
						 unRes.getString("datedebut"),
						 unRes.getString("datefin")));
			}
			unStat.close(); 
			unRes.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesTemps;
	}
	
	public static void insertTemps (Temps unTemps)
	{
		String requete = "INSERT INTO Temps(DateDebut,DateFin) VALUES ( '" + 
				unTemps.getDatedebut()+"','"+
				unTemps.getDatefin()  +"') ; "+
				" SET @idtemps := (SELECT LAST_INSERT_ID() ); ";
		
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try
		{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void deleteTemps (Temps unTemps)
	{
		String requete = "delete from Temps where idTemps =" +
						unTemps.getIdTemps()+"; ";
		
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	public static void updateTemps (Temps unTemps)
	{
		String requete = "update Temps " +
				" set datedebut ='" + unTemps.getDatedebut() +
				"', datefin ='"+ unTemps.getDatefin()+
				"' where idTemps =" + unTemps.getIdTemps()+"; ";
		
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	
}
/******************************************* Tranche *******************************************************/
	public static ArrayList<Tranche> selectAllTranche ()
	{
		ArrayList<Tranche> lesTranches = new ArrayList<Tranche>(); 
		String requete ="Select * from Tranche ;"; 
		Bdd uneBdd = new Bdd("localhost", "regroup", "root", ""); 
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes  = unStat.executeQuery(requete); 
			while (unRes.next())
			{
				lesTranches.add(new Tranche (unRes.getInt("idTranche"),
						 unRes.getInt("palier")));
			}
			unStat.close(); 
			unRes.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lesTranches;
	}
	
	public static void insertTranche (Tranche unTranche)
	{
		String requete = "INSERT INTO Tranche (palier) VALUES ( '" + 
				unTranche.getPalier()+"','"+ "') ; "+
				" SET @idtranche := (SELECT LAST_INSERT_ID() ); ";
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void deleteTranche (Tranche unTranche)
	{
		String requete = "delete from Tranche where idTranche =" +
						unTranche.getIdTranche()+"; ";
		
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	public static void updateTranche (Tranche unTranche)
	{
		String requete = "update Tranche " +
				" set datedebut ='" + unTranche.getPalier() +
				"' where idTranche =" + unTranche.getIdTranche()+"; ";
		
		Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
		try{
			uneBdd.seConnecter(); 
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	
}
/*********************************Media**********************************************************/	
	public static ArrayList<Media> selectAllMedias
	 ()
		{
			ArrayList<Media> lesMedias = new ArrayList<Media>(); 
			String requete ="Select * from Media ;"; 
			Bdd uneBdd = new Bdd("localhost", "regroup", "root", ""); 
			try{
				uneBdd.seConnecter(); 
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes  = unStat.executeQuery(requete); 
				while (unRes.next())
				{
					lesMedias.add(new Media (unRes.getInt("idMedia"),
							 			     unRes.getString("nomMedia"),
							 			     unRes.getString("url")));
				}
				unStat.close(); 
				unRes.close(); 
				uneBdd.seDeConnecter();
			}
			catch (SQLException exp)
			{
				System.out.println("Erreur : " + requete);
			}
			return lesMedias
			;
		}
		
		public static void insertMedia (Media unMedia)
		{	
			/* // création de la boîte de dialogue
            JFileChooser dialogue = new JFileChooser();
             
            // affichage
            dialogue.showOpenDialog(null);
             
            // récupération du fichier sélectionné
            System.out.println("Fichier choisi : " + dialogue.getSelectedFile());*/
			
			String requete = "INSERT INTO Media (nom,URL) VALUES ('" + 
					unMedia.getNom()+"','"+
					unMedia.getUrl() +"',@idproduit) ;";
			Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
			try{
				uneBdd.seConnecter(); 
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close(); 
				uneBdd.seDeConnecter();
			}
			catch (SQLException exp)
			{
				System.out.println("Erreur : " + requete);
			}
		}
		
		public static void deleteMedia (Media unMedia)
		{
			String requete = "delete from Media where idMedia =" +
							unMedia.getIdMedia()+"; ";
			
			Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
			try{
				uneBdd.seConnecter(); 
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close(); 
				uneBdd.seDeConnecter();
			}
			catch (SQLException exp)
			{
				System.out.println("Erreur : " + requete);
			}
		}
		public static void updateMedia (Media unMedia)
		{
			String requete = "update Media " +
					" set nom ='" + unMedia.getNom() +
					"', url ='"+ unMedia.getUrl()+
					"' where idMedia =" + unMedia.getIdMedia()+"; ";
			
			Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
			try{
				uneBdd.seConnecter(); 
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close(); 
				uneBdd.seDeConnecter();
			}
			catch (SQLException exp)
			{
				System.out.println("Erreur : " + requete);
			}
		
	}
/***************** Modele COMPLET *********************/

public static ArrayList<Complet> selectAllComplet()
{
	

	ArrayList<Complet> unComplet= new ArrayList<Complet>(); 
	String requete ="Select * from complet ;"; 
	Bdd uneBdd = new Bdd("localhost", "regroup", "root", ""); 
	try{
		uneBdd.seConnecter(); 
		Statement unStat = uneBdd.getMaConnexion().createStatement(); 
		ResultSet unRes  = unStat.executeQuery(requete); 
		while (unRes.next())
		{
			unComplet.add(new Complet (unRes.getInt("idMedia"),
					 			       unRes.getString("nomMedia"),
					 			       unRes.getString("URL"),
									   unRes.getInt("IdTemps"),
									   unRes.getString("DateDebut"),
									   unRes.getString("DateFin"),
						               unRes.getInt("idtranche"),
			                           unRes.getInt("parlier"),
									   unRes.getInt("idproduit"),
									   unRes.getFloat("prix"),
									   unRes.getString("nom"),
									   unRes.getString("type"),
									   unRes.getString("description"),
									   unRes.getInt("quantite")
									   )
									   );
		 
			
		}
		unStat.close(); 
		unRes.close(); 
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp)
	{
		System.out.println("Erreur : " + requete);
	}
	return unComplet;
}
/*
public static void insertComplet(Complet unComplet)
{
	
	String requete ="INSERT INTO Temps(DateDebut,DateFin) VALUES ( '" + 
						unComplet.getDatedebut()+"','"+
						unComplet.getDatefin()  +"') ;"+ 
						" SET @idtemps := (SELECT LAST_INSERT_ID() ); "+
						
					 "INSERT INTO Tranche (palier) VALUES ( '" + 
					 	unComplet.getPalier()+"');"+ 
					 	" SET @idtranche := (SELECT LAST_INSERT_ID() ); "+
					 "INSERT INTO Produit(prix,nom,type,description,quantite,IdTemps,IdTranche) VALUES ( '" + 
						unComplet.getPrix()+"','"+
						unComplet.getNom() +"','"+
						unComplet.getType() +"','"+
						unComplet.getQuantite()+"','"+ 
						unComplet.getDescription()+"',@idTemps,@idTranche) ; "+
						" SET @idproduit := (SELECT LAST_INSERT_ID() ); "+
						
					"INSERT INTO Media (nom,URL) VALUES ('" + 
						unComplet.getNomMedia()+"','"+
						unComplet.getUrl() +"',@idproduit) ;";
								

	Bdd uneBdd = new Bdd ("localhost", "regroup", "root","");
	try{
		uneBdd.seConnecter(); 
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close(); 
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp)
	{
		System.out.println("Erreur : " + requete);
	}
}*/
public static void deleteComplet(Complet  unComplet)
{}
public static void updateComplet(Complet  unComplet)
{}

/******************************************EXEMPLE*************************/
public static ArrayList<Exemple> selectAllExemples()
{
	

	ArrayList<Exemple> unExemple= new ArrayList<Exemple>(); 
	String requete ="Select * FROM  produit WHERE Quantite<=AlerteQuantite  ;"; 
	Bdd uneBdd = new Bdd("localhost", "regroup", "root", ""); 
	try{
		uneBdd.seConnecter(); 
		Statement unStat = uneBdd.getMaConnexion().createStatement(); 
		ResultSet unRes  = unStat.executeQuery(requete); 
		while (unRes.next())
		{
			unExemple.add(new Exemple(   unRes.getString("nom"),
										unRes.getString("DateDebut"),
										unRes.getInt("quantite"),
							 		    unRes.getString("nomMedia"),
							 		    unRes.getString("Url"))) ;
		 
			
		}
		unStat.close(); 
		unRes.close(); 
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp)
	{
		System.out.println("Erreur : " + requete);
	}
	return unExemple;
}
public static ArrayList<Produit> selectAllRea ()
{
	ArrayList<Produit> lesProduits = new ArrayList<Produit>(); 
	String requete ="Select * FROM  produit WHERE Quantite<=AlerteQuantite  ;"; 
	Bdd uneBdd = new Bdd("localhost", "regroup", "root", ""); 
	try{
		uneBdd.seConnecter(); 
		Statement unStat = uneBdd.getMaConnexion().createStatement(); 
		ResultSet unRes  = unStat.executeQuery(requete); 
		while (unRes.next())
		{
			lesProduits.add(new Produit (unRes.getInt("idProduit"),
					 unRes.getFloat("prix"),
					 unRes.getString("nom"),
					 unRes.getString("type"),
					 unRes.getString("description"),
					 unRes.getInt("quantite"),
					 unRes.getInt("AlerteQuantite")
					 ));
		}
		unStat.close(); 
		unRes.close(); 
		uneBdd.seDeConnecter();
	}
	catch (SQLException exp)
	{
		System.out.println("Erreur : " + requete);
	}
	return lesProduits;
}
}
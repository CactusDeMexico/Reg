package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Complet;
import controleur.Tableau;
import modele.Modele;

public class VueComplet  extends JPanel implements ActionListener 
{
	private JTable tableComplet ; 
	private JPanel panelEdition = new JPanel(); 
	private JButton btAjouter = new JButton("Ajouter"); 
	private JButton btSupprimer = new JButton("Supprimer"); 
	private JButton btMiseAJour = new JButton("Editer");
	//Table Complet
	private JTextField txtIdMedia = new JTextField();
	private JTextField txtUrl = new JTextField();
	private JTextField txtNomMedia = new JTextField(); 
	//Table Temps
	private JTextField txtIdTemps = new JTextField();
	private JTextField DateDeb = new JTextField();
	private JTextField DateFin = new JTextField(); 
	//Table Type
	private JTextField txtIdTranche = new JTextField();
	private JTextField intpalier= new JTextField();
	//Table Produit
	private JTextField txtIdProduit = new JTextField();
	private JTextField floPrix = new JTextField();
	private JTextField txtNom = new JTextField(); 
	private JTextField txtType = new JTextField(); 
	private JTextField intQuantite = new JTextField();
	private JTextField txtDescription = new JTextField();
	/*
	   txtIdComplet txtUrl txtNomComplet
	   txtIdTemps DateDeb DateFin
	   txtIdTranche intPalier
	   txtIdProduit floPrix txtNom intQuantite txtDescription
	   
	*/
	private Tableau unTableau ;
	
	public VueComplet()
	{
		this.setBounds(20, 70, 660, 800); 
		this.setLayout(null); 
		this.setBackground(new Color(211,211,211)); 
		/*Structure*/
		// txtIdComplet txtUrl txtNomComplet
		//txtIdTemps DateDeb DateFin
		//txtIdType txtNomType 
		// txtIdProduit  floPrix txtNom intQuantite txtDescription 
		
		//L'entete Complet Temps Type Produit
		String entete [] = {"Id Media", "Nom image","URL", "Image",
							"IdTemps","DateDeb","DateFin",
							"IdTranche","palier",
							"Id Produit", "Prix ","Nom ","Type", "description","Quantite"
							};
		unTableau = new Tableau(this.recupererLesComplets(), entete);
		this.tableComplet = new JTable(unTableau){
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		this.tableComplet.setRowHeight(100);
		this.tableComplet.setEnabled(true);
		
		
		this.tableComplet.addMouseListener(new MouseListener()
		{
			@Override
				public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent m) {
				 int ligne = tableComplet.getSelectedRow();
				 //Complet
				 txtIdMedia.setText(tableComplet.getValueAt(ligne, 0).toString()); 
				 txtNomMedia.setText(tableComplet.getValueAt(ligne, 1).toString());
				 txtUrl.setText(tableComplet.getValueAt(ligne, 2).toString());
				 //Temps
				 txtIdTemps.setText(tableComplet.getValueAt(ligne, 4).toString()); 
				 DateDeb.setText(tableComplet.getValueAt(ligne,5).toString()); 
				 DateFin.setText(tableComplet.getValueAt(ligne, 6).toString());
				 //Type
				 txtIdTranche.setText(tableComplet.getValueAt(ligne, 7).toString()); 
				 intpalier.setText(tableComplet.getValueAt(ligne, 8).toString());
				 //Produit
				 txtIdProduit.setText(tableComplet.getValueAt(ligne, 9).toString()); 
				 floPrix.setText(tableComplet.getValueAt(ligne, 10).toString()); 
				 txtNom.setText(tableComplet.getValueAt(ligne, 11).toString());
				 txtType.setText(tableComplet.getValueAt(ligne, 12).toString());
				 txtDescription.setText(tableComplet.getValueAt(ligne, 13).toString());
				 intQuantite.setText(tableComplet.getValueAt(ligne,14).toString());
				 
				 
			
		}
	});
		//affichage de la Jtable dans une ScrollTable 
		JScrollPane  uneScroll = new JScrollPane(this.tableComplet);
		uneScroll.setBounds(20, 20, 600, 250); 
		uneScroll.setBackground(Color.black); 
		this.add(uneScroll);
		
		
		//construction du panel edition d'un Complet 
		this.panelEdition.setBounds(20, 290, 600, 60);
		this.panelEdition.setLayout(new GridLayout(2, 4));
		this.panelEdition.add(new JLabel("Id media : "));
		this.panelEdition.add(txtIdMedia); 
		this.panelEdition.add(new JLabel("Nom image: "));
		this.panelEdition.add(txtNomMedia);
		this.panelEdition.add(new JLabel("Url : "));
		this.panelEdition.add(txtUrl);
		this.panelEdition.add(new JLabel("Id Temps : "));
		this.panelEdition.add(txtIdTemps); 
		this.panelEdition.add(new JLabel("Date début : "));
		this.panelEdition.add(DateDeb); 
		this.panelEdition.add(new JLabel("Date fin : "));
		this.panelEdition.add(DateFin); 
		this.panelEdition.add(new JLabel("Id Tranche : "));
		this.panelEdition.add(txtIdTranche); 
		this.panelEdition.add(new JLabel("palier : "));
		this.panelEdition.add(intpalier);
		this.panelEdition.add(new JLabel("Id Produit : "));
		this.panelEdition.add(txtIdProduit); 
		this.panelEdition.add(new JLabel("Prix : "));
		this.panelEdition.add(floPrix); 
		this.panelEdition.add(new JLabel("Nom : "));
		this.panelEdition.add(txtNom);
		this.panelEdition.add(new JLabel("Type : "));
		this.panelEdition.add(txtType);
		this.panelEdition.add(new JLabel("Description :")); 
		this.panelEdition.add(txtDescription); 
		this.panelEdition.add(new JLabel("Quantite :")); 
		this.panelEdition.add(intQuantite); 
		
		this.add(this.panelEdition);
		this.btAjouter.setBounds(200, 370, 100, 20); 
		this.add(btAjouter); 
		
		this.btSupprimer.setBounds(350, 370, 100, 20); 
		this.add(btSupprimer); 
		
		this.btMiseAJour.setBounds(470, 370, 100, 20); 
		this.add(btMiseAJour); 
		
		this.txtIdMedia.setEditable(false);
		
		//rendre les boutons cliquables 
		this.btAjouter.addActionListener(this); 
		this.btSupprimer.addActionListener(this);
		this.btMiseAJour.addActionListener(this);
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btAjouter)
		 {
			/* txtIdComplet txtUrl txtNomComplet
			   txtIdTemps DateDeb DateFin
			   txtIdType txtNomType 
			   txtIdProduit floPrix txtNom intQuantite txtDescription*/
			 Complet unComplet = new Complet(	txtNomMedia.getText(),txtUrl.getText(),
					 							DateDeb.getText(),DateFin.getText(),
					 							Integer.parseInt(intpalier.getText()),
					 							Float.parseFloat(floPrix.getText()),
					 							txtNom.getText(),
					 							txtType.getText(),txtDescription.getText(),
					 							Integer.parseInt(intQuantite.getText())
					 							 );
			 
			 
			
			// Modele.insertComplet(unComplet);
			 JOptionPane.showMessageDialog(this, "Insertion réussie");
			  //Complet
			 txtNomMedia.setText(""); 
			 txtUrl.setText("");
			 //temps
			 DateDeb.setText(""); 
			 DateFin.setText("");
			 //Type
			 intpalier.setText("");
			 //produit
			 floPrix.setText(""); 
			 txtNom.setText(""); 
			 txtType.setText(""); 
			 intQuantite.setText("");
			 txtDescription.setText("");
			 
			 Object data [] = {unComplet.getIdMedia()+"", unComplet.getNomMedia(),unComplet.getUrl(),
					 unComplet.getIdTemps()+"",unComplet.getDatedebut(),unComplet.getDatefin(),
					 unComplet.getIdTranche()+"",unComplet.getPalier(),
					 unComplet.getIdProduit()+"",unComplet.getPrix(),unComplet.getNom(),unComplet.getType(),unComplet.getDescription(),unComplet.getQuantite()};
			 
			 this.unTableau.add(data);
				/*Structure*/
				// txtIdComplet txtUrl txtNomComplet
				//txtIdTemps DateDeb DateFin
				//txtIdType txtNomType 
				// txtIdProduit  floPrix txtNom intQuantite txtDescription 
			 /*
			 Client unClient = new Client(txtNom.getText(), 
					 txtPrenom.getText(), txtAdresse.getText());
			 Modele.insertClient(unClient);
			 JOptionPane.showMessageDialog(this, "Insertion réussie");
			 txtNom.setText(""); 
			 txtPrenom.setText(""); 
			 txtAdresse.setText("");
			  * */
		 }
		 else if (e.getSource() == this.btSupprimer)
		 {
			/* int idComplet = Integer.parseInt(txtIdComplet.getText());
			 Complet unComplet = new Complet(Integer.parseInt(txtIdMedia.getText()),
					txtNom.getText(),txtUrl.getText());
			 Modele.deleteComplet(unComplet);
			 JOptionPane.showMessageDialog(this, "Suppression effectuée");
			 txtIdMedia.setText("");
			 txtUrl.setText("");
			 txtNom.setText(""); 
			 int rowIndex = tableComplet.getSelectedRow();
			 unTableau.remove(rowIndex);*/
		 }
		 else if (e.getSource() == this.btMiseAJour)
		 {/*
			 int idComplet = Integer.parseInt(txtIdComplet.getText());
			 Complet unComplet = new Complet(Integer.parseInt(txtIdComplet.getText()),
					 txtNom.getText(),txtUrl.getText());
			 Modele.updateComplet(unComplet);
			 JOptionPane.showMessageDialog(this, "Mise à jour effectuée");
			 Object data [] = {unComplet.getIdComplet()+"", unComplet.getNom(),unComplet.getUrl()};
			 int rowIndex = tableComplet.getSelectedRow();
			 this.unTableau.update(rowIndex, data);
			 txtIdComplet.setText("");
			 txtNom.setText(""); 
			 txtUrl.setText("");*/
		 }
		
	}
	
			
	//recuperer les données sous forme d'une matrice 
	private Object [][] recupererLesComplets ()
	{
		ArrayList<Complet> LesComplets = Modele.selectAllComplet();
		Object [][] donnees = new Object[LesComplets.size()][Complet.getNbChampsComplet()];
		int i =0; 
		for (Complet unComplet : LesComplets)
		{
			donnees[i][0]  = unComplet.getIdMedia() + ""; 
			donnees[i][1]  = unComplet.getNomMedia();
			donnees[i][2]  = unComplet.getUrl();	
			
			String url =  unComplet.getUrl();
			ImageIcon imagenorm = new ImageIcon("src/images/" + url); // load the image to a imageIcon
			
	        Image image = imagenorm.getImage(); // transform it
	
	        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
	
	        imagenorm = new ImageIcon(newimg);  // transform it back
	
			donnees[i][3]= image;
			
			donnees[i][4]  = unComplet.getIdTemps()+"";
			donnees[i][5]  = unComplet.getDatedebut();
			donnees[i][6]  = unComplet.getDatefin();
			donnees[i][7]  = unComplet.getidTranche()+"";
			donnees[i][8]  = unComplet.getpalier();
			donnees[i][10]  = unComplet.getIdProduit()+"";
			donnees[i][11]  = unComplet.getNom();
			donnees[i][12]  = unComplet.getType();
			donnees[i][13]  = unComplet.getDescription();
			donnees[i][14]  = unComplet.getQuantite();
			i++;
		}


		return donnees;
	}



		
	}


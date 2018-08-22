package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//import controleur.Client;
import controleur.Produit;
import controleur.Tableau;
import modele.Modele;
//JFileChooser
/* JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(parent);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName());
    }*/
public class VueProduit extends JPanel implements ActionListener
{
	private JTable tableProduit ; 
	private JPanel panelEdition = new JPanel(); 
	private JButton btAjouter = new JButton("Ajouter"); 
	private JButton btSupprimer = new JButton("Supprimer"); 
	private JButton btMiseAJour = new JButton("Editer");
	
	private JTextField txtIdProduit = new JTextField();
	private JTextField floPrix = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtType = new JTextField(); 
	private JTextField intQuantite = new JTextField();
	private JTextField txtDescription = new JTextField(); 
	private JTextField intAlerteQuantite = new JTextField(); 
	private Tableau unTableau ; 
	
	public VueProduit()
	{
		this.setBounds(20, 70, 660, 400); 
		this.setLayout(null); 
		this.setBackground(new Color(211,211,211)); 
		
		//construction de la Jtable 
		String entete [] = {"Id Produit", "Prix Produit","Nom Produit","Type","description", "Quantite ",
				"AlerteQuantite "
				};
		
		this.tableProduit = new JTable(this.recupererLesProduit(), entete){
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		this.tableProduit.setEnabled(true);
		
		
		this.tableProduit.addMouseListener(new MouseListener() {
			
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
					 int ligne = tableProduit.getSelectedRow(); 
					 txtIdProduit.setText(tableProduit.getValueAt(ligne, 0).toString()); 
					 floPrix.setText(tableProduit.getValueAt(ligne, 1).toString()); 
					 txtNom.setText(tableProduit.getValueAt(ligne, 2).toString());
					 txtType.setText(tableProduit.getValueAt(ligne, 3).toString());
					 txtDescription.setText(tableProduit.getValueAt(ligne, 4).toString());
					 intQuantite.setText(tableProduit.getValueAt(ligne,5).toString());
					 intAlerteQuantite.setText(tableProduit.getValueAt(ligne,6).toString());
					 
					 
				
			}
		});
		
		//affichage de la Jtable dans une ScrollTable 
		JScrollPane  uneScroll = new JScrollPane(this.tableProduit);
		uneScroll.setBounds(20, 20, 600, 250); 
		uneScroll.setBackground(Color.GRAY); 
		this.add(uneScroll);
		
		//construction du panel edition d'un Produit 
		this.panelEdition.setBounds(20, 290, 600, 60);
		this.panelEdition.setLayout(new GridLayout(2, 4));
		this.panelEdition.add(new JLabel("Id Produit : "));
		this.panelEdition.add(txtIdProduit); 
		this.panelEdition.add(new JLabel("Prix : "));
		this.panelEdition.add(floPrix); 
		this.panelEdition.add(new JLabel("Nom : "));
		this.panelEdition.add(txtNom);
		this.panelEdition.add(new JLabel("Type : "));
		this.panelEdition.add(txtType);
		this.panelEdition.add(new JLabel("Quantite :")); 
		this.panelEdition.add(intQuantite); 
		this.panelEdition.add(new JLabel("Description :")); 
		this.panelEdition.add(txtDescription); 
		this.panelEdition.add(new JLabel("AlerteProduit :")); 
		this.panelEdition.add(intAlerteQuantite); 
		this.add(this.panelEdition);
		this.btAjouter.setBounds(200, 370, 100, 20); 
		this.add(btAjouter); 
		
		this.btSupprimer.setBounds(350, 370, 100, 20); 
		this.add(btSupprimer); 
		
		this.btMiseAJour.setBounds(500, 370, 100, 20); 
		this.add(btMiseAJour); 
		
		this.txtIdProduit.setEditable(false);
		
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
			 Produit unProduit = new Produit(
					 Float.parseFloat(floPrix.getText()),txtNom.getText(), txtType.getText(),txtDescription.getText(),
					 Integer.parseInt(intQuantite.getText()),
					 Integer.parseInt(intAlerteQuantite.getText())
					 );
			 Modele.insertProduit(unProduit);
			 JOptionPane.showMessageDialog(this, "Insertion réussie");
			 floPrix.setText(""); 
			 txtNom.setText(""); 
			 txtType.setText(""); 
			 intQuantite.setText("");
			 txtDescription.setText("");
			 intAlerteQuantite.setText("");
			 Object data [] = {unProduit.getIdProduit()+"",unProduit.getPrix(), unProduit.getNom(),unProduit.getType(),unProduit.getDescription(),
					 unProduit.getQuantite(),unProduit.getAlerteQuantite()
					 };
			 this.unTableau.add(data);
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
			 int idProduit = Integer.parseInt(txtIdProduit.getText());
			 Produit unProduit = new Produit(Integer.parseInt(txtIdProduit.getText()),
					 Float.parseFloat(floPrix.getText()),txtNom.getText(),txtType.getText(), txtDescription.getText(),
					 Integer.parseInt(intQuantite.getText()),
					 Integer.parseInt(intAlerteQuantite.getText())
					 );
			 Modele.deleteProduit(unProduit);
			 JOptionPane.showMessageDialog(this, "Suppression effectuée");
			 txtIdProduit.setText("");
			 txtIdProduit.setText("");
			 floPrix.setText("");
			 txtNom.setText(""); 
			 txtType.setText("");  
			 intQuantite.setText("");
			 txtDescription.setText("");
			 intAlerteQuantite.setText("");
			 int rowIndex = tableProduit.getSelectedRow();
			 unTableau.remove(rowIndex);
		 }
		 else if (e.getSource() == this.btMiseAJour)
		 {
			 int idProduit = Integer.parseInt(txtIdProduit.getText());
			 Produit unProduit = new Produit(Integer.parseInt(txtIdProduit.getText()),
					 Float.parseFloat(floPrix.getText()),txtNom.getText(),txtType.getText(),txtDescription.getText(), 
					 Integer.parseInt(intQuantite.getText()),
					 Integer.parseInt(intAlerteQuantite.getText())
					 );
			 
			 Modele.updateProduit(unProduit);
			 JOptionPane.showMessageDialog(this, "Mise à jour effectuée");
			 txtIdProduit.setText("");
			 floPrix.setText("");
			 txtNom.setText(""); 
			 txtType.setText(""); 
			 intQuantite.setText("");
			 txtDescription.setText("");
			 intAlerteQuantite.setText("");
			 Object data [] = {unProduit.getIdProduit()+"",unProduit.getPrix(), unProduit.getNom(),unProduit.getType(),
					 unProduit.getQuantite(),unProduit.getDescription(),unProduit.getAlerteQuantite()};
			 int rowIndex = tableProduit.getSelectedRow();
			 this.unTableau.update(rowIndex, data);
		 }
		
	}
	//recuperer les données sous forme d'une matrice 
	private Object [][] recupererLesProduit ()
	{
		ArrayList<Produit> lesProduit = Modele.selectAllProduits();
		Object [][] donnees = new Object[lesProduit.size()][Produit.getNbChampsProduits()];
		int i =0; 
		for (Produit unProduit : lesProduit)
		{
			donnees[i][0]  = unProduit.getIdProduit() + ""; 
			donnees[i][1]  = unProduit.getPrix(); 
			donnees[i][2]  = unProduit.getNom();
			donnees[i][3]  = unProduit.getType();
			donnees[i][4]  = unProduit.getDescription();
			donnees[i][5]  = unProduit.getQuantite();
			donnees[i][6]  = unProduit.getAlerteQuantite();
			
			i++;
		}
		return donnees;
	}

}

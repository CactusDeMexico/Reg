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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



//import controleur.Client;
import controleur.Exemple;
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
public class VueExemple extends JPanel implements ActionListener
{
	private JTable tableExemple ; 
	private JPanel panelEdition = new JPanel(); 
	private JButton btAjouter = new JButton("Ajouter"); 
	private JButton btSupprimer = new JButton("Supprimer"); 
	private JButton btMiseAJour = new JButton("Editer");
	
	private JTextField Nom = new JTextField();
	private JTextField DateDebut = new JTextField();
	private JTextField Quantite = new JTextField();
	private JTextField Nomimage = new JTextField(); 
	private JTextField Url = new JTextField(); 
	
	private Tableau unTableau ; 
	
	public VueExemple()
	{
		this.setBounds(20, 70, 660, 400); 
		this.setLayout(null); 
		this.setBackground(new Color(211,211,211)); 
		
		//construction de la Jtable 
		String entete [] = {"Nom", "DateDebut","Quantite","nom image", "Image "
				};
		
		this.tableExemple = new JTable(this.recupererLesExemple(), entete){
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		this.tableExemple.setEnabled(true);
		this.tableExemple.setRowHeight(100);
		
		this.tableExemple.addMouseListener(new MouseListener() {
			
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
					 int ligne = tableExemple.getSelectedRow(); 
					 Nom.setText(tableExemple.getValueAt(ligne, 0).toString()); 
					 DateDebut.setText(tableExemple.getValueAt(ligne, 1).toString()); 
					 Quantite.setText(tableExemple.getValueAt(ligne, 2).toString());
					 Nomimage.setText(tableExemple.getValueAt(ligne, 3).toString());
					// Url.setText(tableExemple.getValueAt(ligne, 4).toString());
					
					 
					 
				
			}
		});
		
		//affichage de la Jtable dans une ScrollTable 
		JScrollPane  uneScroll = new JScrollPane(this.tableExemple);
		uneScroll.setBounds(20, 20, 600, 250); 
		uneScroll.setBackground(Color.GRAY); 
		this.add(uneScroll);
		
		//construction du panel edition d'un Exemple 
		this.panelEdition.setBounds(20, 290, 600, 60);
		this.panelEdition.setLayout(new GridLayout(2, 4));
		this.panelEdition.add(new JLabel("Nom: "));
		this.panelEdition.add(Nom); 
		this.panelEdition.add(new JLabel("Date début: "));
		this.panelEdition.add(DateDebut); 
		this.panelEdition.add(new JLabel("Quantité : "));
		this.panelEdition.add(Quantite);
		this.panelEdition.add(new JLabel("Nom image : "));
		this.panelEdition.add(Nomimage);
		
		this.add(this.panelEdition);
		this.btAjouter.setBounds(200, 370, 100, 20); 
		this.add(btAjouter); 
		
		this.btSupprimer.setBounds(350, 370, 100, 20); 
		this.add(btSupprimer); 
		
		this.btMiseAJour.setBounds(500, 370, 100, 20); 
		this.add(btMiseAJour); 
		
		
		
		//rendre les boutons cliquables 
		this.btAjouter.addActionListener(this); 
		this.btSupprimer.addActionListener(this);
		this.btMiseAJour.addActionListener(this);
		
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/* if (e.getSource() == this.btAjouter)
		 {
			 Exemple unExemple = new Exemple(
					Nom.getText(),DateDebut.getText(),
					 Integer.parseInt(Quantite.getText()),
					 Nomimage.getText(),Url.getText());
			 Modele.insertExemple(unExemple);
			 JOptionPane.showMessageDialog(this, "Insertion réussie");
			 Nom.setText(""); 
			 DateDebut.setText(""); 
			 Quantite.setText(""); 
			 Nomimage.setText("");
			 Url.setText("");
			 Object data [] = {unExemple.getNom()+"",unExemple.getDateDebut(),
					 		   unExemple.getQuantite(),unExemple.getNomimage(),
					 		   unExemple.getUrl()
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
			  * 
		 }
		 else if (e.getSource() == this.btSupprimer)
		 {
			 String Nom = Nom.getText();
			 Exemple unExemple = new Exemple(Nom.getText(),
					 Float.parseFloat(floPrix.getText()),txtNom.getText(),txtType.getText(), txtDescription.getText(),
					 Integer.parseInt(intQuantite.getText()));
			 Modele.deleteExemple(unExemple);
			 JOptionPane.showMessageDialog(this, "Suppression effectuée");
			 txtIdExemple.setText("");
			 txtIdExemple.setText("");
			 floPrix.setText("");
			 txtNom.setText(""); 
			 txtType.setText("");  
			 intQuantite.setText("");
			 txtDescription.setText("");
			 int rowIndex = tableExemple.getSelectedRow();
			 unTableau.remove(rowIndex);
		 }
		 else if (e.getSource() == this.btMiseAJour)
		 {
			String Nom = Nom.getText();
			 Exemple unExemple = new Exemple(Integer.parseInt(txtIdExemple.getText()),
					 Float.parseFloat(floPrix.getText()),txtNom.getText(),txtType.getText(),txtDescription.getText(), 
					 Integer.parseInt(intQuantite.getText()));
			 Modele.updateExemple(unExemple);
			 JOptionPane.showMessageDialog(this, "Mise à jour effectuée");
			 txtIdExemple.setText("");
			 floPrix.setText("");
			 txtNom.setText(""); 
			 txtType.setText(""); 
			 intQuantite.setText("");
			 txtDescription.setText("");
			 Object data [] = {unExemple.getIdExemple()+"",unExemple.getPrix(), unExemple.getNom(),unExemple.getType(),
					 unExemple.getQuantite(),unExemple.getDescription()};
			 int rowIndex = tableExemple.getSelectedRow();
			 this.unTableau.update(rowIndex, data);
		 }*/
		
	}
	//recuperer les données sous forme d'une matrice 
	private Object [][] recupererLesExemple ()
	{
		ArrayList<Exemple> lesExemple = Modele.selectAllExemples();
		Object [][] donnees = new Object[lesExemple.size()][Exemple.getNbChampsexemples()];
		int i =0; 
		for (Exemple unExemple : lesExemple)
		{
			 
			donnees[i][0]  = unExemple.getNom();
			donnees[i][1]  = unExemple.getDateDebut();
			donnees[i][2]  = unExemple.getQuantite();
			donnees[i][3]  = unExemple.getNomimage();
			String url =  unExemple.getUrl();
			
			
			ImageIcon imagenorm = new ImageIcon("src/images/" + url); // load the image to a imageIcon
			
			        Image image = imagenorm.getImage(); // transform it
			
			        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
			
			        imagenorm = new ImageIcon(newimg);  // transform it back
			donnees[i][4]  = imagenorm;
			
			
			i++;
		}
		return donnees;
	}

}


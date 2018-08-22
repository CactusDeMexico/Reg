package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import controleur.Tableau;
import controleur.Media;
import modele.Modele;
public class VueMedia extends JPanel implements ActionListener
{
	private JTextField txtIdMedia = new JTextField();
	private JTextField txtUrl = new JTextField();
	private JTextField txtNom = new JTextField(); 
	private Tableau unTableau ; 
	
	private JTable tableMedia ; 
	private JPanel panelEdition = new JPanel(); 
	private JButton btAjouter = new JButton("Ajouter"); 
	private JButton btSupprimer = new JButton("Supprimer"); 
	private JButton btMiseAJour = new JButton("Editer");
	
	
	public VueMedia()
	{
		this.setBounds(20, 70, 660, 400); 
		this.setLayout(null); 
		this.setBackground(new Color(211,211,211)); 
		
		
		//test selection
		/* JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "JPG & GIF Images", "jpg", "gif");
	    chooser.setFileFilter(filter);
	    int returnVal =0;//= chooser.showOpenDialog(parent);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }*/
	    
				
				//construction de la Jtable 
				String entete [] = {"Id Media", "Nom image","URL", "Image"};
				unTableau = new Tableau(this.recupererLesMedias(), entete);
				this.tableMedia = new JTable(unTableau){
					@Override
				    public boolean isCellEditable(int row, int column) {
				        return false;
				    }
				};
				this.tableMedia.setEnabled(true);
				
				this.tableMedia.setRowHeight(100);
				this.tableMedia.addMouseListener(new MouseListener() {
					
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
							 int ligne = tableMedia.getSelectedRow(); 
							 txtIdMedia.setText(tableMedia.getValueAt(ligne, 0).toString()); 
							 txtNom.setText(tableMedia.getValueAt(ligne, 1).toString()); 
							 txtUrl.setText(tableMedia.getValueAt(ligne, 2).toString());
							 
						
					}
				});
				
				//affichage de la Jtable dans une ScrollTable 
				JScrollPane  uneScroll = new JScrollPane(this.tableMedia);
				uneScroll.setBounds(20, 20, 600, 250); 
				uneScroll.setBackground(Color.black); 
				this.add(uneScroll);
				
				
				//construction du panel edition d'un Media 
				this.panelEdition.setBounds(20, 290, 600, 60);
				this.panelEdition.setLayout(new GridLayout(2, 4));
				this.panelEdition.add(new JLabel("Id Media : "));
				this.panelEdition.add(txtIdMedia); 
				this.panelEdition.add(new JLabel("Nom : "));
				this.panelEdition.add(txtNom);
				this.panelEdition.add(new JLabel("Url : "));
				this.panelEdition.add(txtUrl);
			
				this.add(this.panelEdition);
				this.btAjouter.setBounds(200, 370, 100, 20); 
				this.add(btAjouter); 
				
				this.btSupprimer.setBounds(350, 370, 100, 20); 
				this.add(btSupprimer); 
				
				this.btMiseAJour.setBounds(500, 370, 100, 20); 
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
					 
					 Media unMedia = new Media(txtNom.getText(),txtUrl.getText());
					 Modele.insertMedia(unMedia);
					 JOptionPane.showMessageDialog(this, "Insertion réussie");
					  
					 txtNom.setText(""); 
					 txtUrl.setText("");
					 Object data [] = {unMedia.getIdMedia()+"", unMedia.getNom(), unMedia.getNom(),unMedia.getUrl()};
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
					 int idMedia = Integer.parseInt(txtIdMedia.getText());
					 Media unMedia = new Media(Integer.parseInt(txtIdMedia.getText()),
							txtNom.getText(),txtUrl.getText());
					 Modele.deleteMedia(unMedia);
					 JOptionPane.showMessageDialog(this, "Suppression effectuée");
					 txtIdMedia.setText("");
					 txtUrl.setText("");
					 txtNom.setText(""); 
					 int rowIndex = tableMedia.getSelectedRow();
					 unTableau.remove(rowIndex);
				 }
				 else if (e.getSource() == this.btMiseAJour)
				 {
					 int idMedia = Integer.parseInt(txtIdMedia.getText());
					 Media unMedia = new Media(Integer.parseInt(txtIdMedia.getText()),
							 txtNom.getText(),txtUrl.getText());
					 Modele.updateMedia(unMedia);
					 JOptionPane.showMessageDialog(this, "Mise à jour effectuée");
					 Object data [] = {unMedia.getIdMedia()+"", unMedia.getNom(),unMedia.getUrl()};
					 int rowIndex = tableMedia.getSelectedRow();
					 this.unTableau.update(rowIndex, data);
					 txtIdMedia.setText("");
					 txtNom.setText(""); 
					 txtUrl.setText("");
				 }
				
			}
			
					
			//recuperer les données sous forme d'une matrice 
			private Object [][] recupererLesMedias ()
			{
				ArrayList<Media> LesMedias = Modele.selectAllMedias();
				Object [][] donnees = new Object[LesMedias.size()][Media.getNbChampsMedia()];
				int i =0; 
				for (Media unMedia : LesMedias)
				{
					donnees[i][0]  = unMedia.getIdMedia() + ""; 
					donnees[i][1]  = unMedia.getNom();
					donnees[i][2]  = unMedia.getUrl();	
					String url =  unMedia.getUrl();
					
					
					ImageIcon imagenorm = new ImageIcon("src/images/" + url); // load the image to a imageIcon
					
					        Image image = imagenorm.getImage(); // transform it
					
					        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
					
					        imagenorm = new ImageIcon(newimg);  // transform it back
					
					donnees[i][3]= imagenorm;
					i++;
				}


				return donnees;
			}

		
	}
	


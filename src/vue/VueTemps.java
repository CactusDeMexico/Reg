package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//import controleur.Client;
import controleur.Temps;


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
public class VueTemps extends JPanel implements ActionListener
{
	private JTable tableTemps ; 
	private JPanel panelEdition = new JPanel(); 
	private JButton btAjouter = new JButton("Ajouter"); 
	private JButton btSupprimer = new JButton("Supprimer"); 
	private JButton btMiseAJour = new JButton("Editer");
	
	
	/* DateFormat format = new SimpleDateFormat("yyyy--MMMM--dd");
	private JFormattedTextField DateDeb = new JFormattedTextField(format);
	private JFormattedTextField DateFin = new JFormattedTextField(format);*/
	private JTextField txtIdTemps = new JTextField();
	private JTextField DateDeb = new JTextField();
	private JTextField DateFin = new JTextField(); 
	/*private JTextField TxtIdType = new JTextField();
	private JTextField txtNom = new JTextField(); */
	
	public VueTemps()
	{
		this.setBounds(20, 70, 660, 400); 
		this.setLayout(null); 
		this.setBackground(new Color(211,211,211)); 
		
		//construction de la Jtable 
		String entete [] = {"Id Temps", "Date début","Date fin"};
		
		this.tableTemps = new JTable(this.recupererLesTemps(), entete)
		{
			@Override
		    public boolean isCellEditable(int row, int column) 
			{
		        return false;
		    }
		};
		this.tableTemps.setEnabled(true);
		
		
		this.tableTemps.addMouseListener(new MouseListener() {
			
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
					 int ligne = tableTemps.getSelectedRow(); 
					 txtIdTemps.setText(tableTemps.getValueAt(ligne, 0).toString()); 
					 DateDeb.setText(tableTemps.getValueAt(ligne, 1).toString()); 
					 DateFin.setText(tableTemps.getValueAt(ligne, 2).toString());
					 
					 
				
			}
		});
		
		//affichage de la Jtable dans une ScrollTable 
		JScrollPane  uneScroll = new JScrollPane(this.tableTemps);
		uneScroll.setBounds(20, 20, 600, 250); 
		uneScroll.setBackground(Color.black); 
		this.add(uneScroll);
		
		//construction du panel edition d'un Temps 
		this.panelEdition.setBounds(20, 290, 600, 60);
		this.panelEdition.setLayout(new GridLayout(2, 4));
		this.panelEdition.add(new JLabel("Id Temps : "));
		this.panelEdition.add(txtIdTemps); 
		this.panelEdition.add(new JLabel("Date début : "));
		this.panelEdition.add(DateDeb); 
		this.panelEdition.add(new JLabel("Date fin : "));
		this.panelEdition.add(DateFin); 
		this.add(this.panelEdition);
		this.btAjouter.setBounds(200, 370, 100, 20); 
		this.add(btAjouter); 
		
		this.btSupprimer.setBounds(350, 370, 100, 20); 
		this.add(btSupprimer); 
		
		this.btMiseAJour.setBounds(500, 370, 100, 20); 
		this.add(btMiseAJour); 
		
		this.txtIdTemps.setEditable(false);
		
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
			 Temps unTemps = new Temps(
					 DateDeb.getText(),DateFin.getText());
			 Modele.insertTemps(unTemps);
			 JOptionPane.showMessageDialog(this, "Insertion réussie");
			 DateDeb.setText(""); 
			 DateFin.setText(""); 
			
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
			 int idTemps = Integer.parseInt(txtIdTemps.getText());
			 Temps unTemps = new Temps(Integer.parseInt(txtIdTemps.getText()),
					 DateDeb.getText(),DateFin.getText());
			 Modele.deleteTemps(unTemps);
			 JOptionPane.showMessageDialog(this, "Suppression effectuée");
			 txtIdTemps.setText("");
			
		 }
		 else if (e.getSource() == this.btMiseAJour)
		 {
			 int idTemps = Integer.parseInt(txtIdTemps.getText());
			 Temps unTemps = new Temps(Integer.parseInt(txtIdTemps.getText()),
					 DateDeb.getText(),DateFin.getText());
			 Modele.updateTemps(unTemps);
			 JOptionPane.showMessageDialog(this, "Mise à jour effectuée");
			 txtIdTemps.setText("");
			 
			
		 }
		
	}
	//recuperer les données sous forme d'une matrice 
	private Object [][] recupererLesTemps ()
	{
		ArrayList<Temps> lesTemps = Modele.selectAllTemps();
		Object [][] donnees = new Object[lesTemps.size()][Temps.getNbChampsTemps()];
		int i =0; 
		for (Temps unTemps : lesTemps)
		{
			donnees[i][0]  = unTemps.getIdTemps() + ""; 
			donnees[i][1]  = unTemps.getDatedebut(); 
			donnees[i][2]  = unTemps.getDatefin();
			i++;
		}
		return donnees;
	}



	}
	


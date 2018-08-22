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
	import controleur.Tranche;


	import modele.Modele;




	public class VueTranche extends JPanel implements ActionListener
	{
		private JTable tableTranche ; 
		private JPanel panelEdition = new JPanel(); 
		private JButton btAjouter = new JButton("Ajouter"); 
		private JButton btSupprimer = new JButton("Supprimer"); 
		private JButton btMiseAJour = new JButton("Editer");
	
		private JTextField txtIdTranche = new JTextField();
		private JTextField Palier = new JTextField();

		
		public VueTranche()
		{
			this.setBounds(20, 70, 660, 400); 
			this.setLayout(null); 
			this.setBackground(new Color(211,211,211)); 
			
			//construction de la Jtable 
			String entete [] = {"Id Tranche", "Palier"};
			
			this.tableTranche = new JTable(this.recupererLesTranche(), entete)
			{
				@Override
			    public boolean isCellEditable(int row, int column) 
				{
			        return false;
			    }
			};
			this.tableTranche.setEnabled(true);
			
			
			this.tableTranche.addMouseListener(new MouseListener() {
				
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
						 int ligne = tableTranche.getSelectedRow(); 
						 txtIdTranche.setText(tableTranche.getValueAt(ligne, 0).toString()); 
						 Palier.setText(tableTranche.getValueAt(ligne, 1).toString()); 
						
						 
						 
					
				}
			});
			
			//affichage de la Jtable dans une ScrollTable 
			JScrollPane  uneScroll = new JScrollPane(this.tableTranche);
			uneScroll.setBounds(20, 20, 600, 250); 
			uneScroll.setBackground(Color.black); 
			this.add(uneScroll);
			
			//construction du panel edition d'un Tranche 
			this.panelEdition.setBounds(20, 290, 600, 60);
			this.panelEdition.setLayout(new GridLayout(2, 4));
			this.panelEdition.add(new JLabel("Id Tranche : "));
			this.panelEdition.add(txtIdTranche); 
			this.panelEdition.add(new JLabel("Palier : "));
			this.panelEdition.add(Palier); 
			 
			this.add(this.panelEdition);
			this.btAjouter.setBounds(200, 370, 100, 20); 
			this.add(btAjouter); 
			
			this.btSupprimer.setBounds(350, 370, 100, 20); 
			this.add(btSupprimer); 
			
			this.btMiseAJour.setBounds(500, 370, 100, 20); 
			this.add(btMiseAJour); 
			
			this.txtIdTranche.setEditable(false);
			
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
				 Tranche unTranche = new Tranche(
						 Integer.parseInt(Palier.getText()));
				 Modele.insertTranche(unTranche);
				 JOptionPane.showMessageDialog(this, "Insertion réussie");
				 Palier.setText(""); 
				
				
				
			 }
			 else if (e.getSource() == this.btSupprimer)
			 {
				 int idTranche = Integer.parseInt(txtIdTranche.getText());
				 Tranche unTranche = new Tranche(Integer.parseInt(txtIdTranche.getText()),
						 Integer.parseInt(Palier.getText()));
				 Modele.deleteTranche(unTranche);
				 JOptionPane.showMessageDialog(this, "Suppression effectuée");
				 txtIdTranche.setText("");
				
			 }
			 else if (e.getSource() == this.btMiseAJour)
			 {
				 int idTranche = Integer.parseInt(txtIdTranche.getText());
				 Tranche unTranche = new Tranche(Integer.parseInt(txtIdTranche.getText()),
						 Integer.parseInt(Palier.getText()));
				 Modele.updateTranche(unTranche);
				 JOptionPane.showMessageDialog(this, "Mise à jour effectuée");
				 txtIdTranche.setText("");
				 
				
			 }
			
		}
		//recuperer les données sous forme d'une matrice 
		private Object [][] recupererLesTranche ()
		{
			ArrayList<Tranche> lesTranche = Modele.selectAllTranche();
			Object [][] donnees = new Object[lesTranche.size()][Tranche.getNbChampsTranche()];
			int i =0; 
			for (Tranche unTranche : lesTranche)
			{
				donnees[i][0]  = unTranche.getIdTranche() + ""; 
				donnees[i][1]  = unTranche.getPalier(); 
				
				i++;
			}
			return donnees;
		}



		}
		




package vue;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Exemple;
import controleur.Main;

public class VueGeneral extends JFrame implements ActionListener
{
	private JPanel panelMenu = new JPanel(); 
	private JButton tabButton [] = new JButton[6]; 
	private  final String tabNoms[] = {"Temps", "Tranche", "Produit","Media", "Reaprovi","Quitter"};

	//creation des trois Panels 
	private static VueRea uneVueRea = new VueRea();
	private static VueProduit uneVueProduit = new VueProduit(); 
	private static VueMedia uneVueMedia = new VueMedia(); 
	private static VueTemps uneVueTemps = new VueTemps();
	private static VueTranche uneVueTranche = new VueTranche();
	//private static VueComplet uneVueComplete = new VueComplet();
	
	public VueGeneral(String Nom) {
		 
			 this.setTitle("Gestion des Stock");
			 this.setLayout(null); 
			 this.setResizable(false); 
			 this.setBounds(200, 200, 700, 500); 
			 this.getContentPane().setBackground(Color.gray);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			 this.panelMenu.setBounds(0, 20, 700, 30); 
			 this.panelMenu.setLayout(new GridLayout(1, 5)); 
			 //construction des boutons dans le panel 
			 for (int i =0; i<6; i++)
			 {
				 this.tabButton[i] = new JButton(tabNoms[i]);
				 this.panelMenu.add(this.tabButton[i]);
				 this.tabButton[i].addActionListener(this);
			 }
			 this.panelMenu.setVisible(true);
			 this.add(this.panelMenu);
			
				
			 
			 //ajout des trois Panels 
			 this.add(uneVueProduit); 
		    // this.add(uneVueComplete);
			 this.add(uneVueMedia);
			 this.add(uneVueTemps);
			 this.add(uneVueTranche);
			 this.add(uneVueRea);
			 this.setVisible(true);
			
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.tabButton[5])
		{
			this.dispose(); 
			 Main.rendreVisible(true);
		} 
		else if (e.getSource() == this.tabButton[0])
		{
			uneVueProduit.setVisible(false); 
			//uneVueComplete.setVisible(false); 
			uneVueMedia.setVisible(false);
			uneVueTemps.setVisible(true);
			uneVueTranche.setVisible(false);
		}
		else if (e.getSource() == this.tabButton[1])
		{
			uneVueRea.setVisible(false);
			uneVueProduit.setVisible(false); 
			uneVueMedia.setVisible(false);
			uneVueTemps.setVisible(false);
			uneVueTranche.setVisible(true); 
		}
		else if (e.getSource() == this.tabButton[2])
		{
			uneVueProduit.setVisible(true); 
			//uneVueComplete.setVisible(false); 
			uneVueMedia.setVisible(false);
			uneVueTemps.setVisible(false);
			uneVueTranche.setVisible(false);
			uneVueRea.setVisible(false);
			
		}
		else if (e.getSource() == this.tabButton[3])
		{
			
			
			uneVueProduit.setVisible(false); 
			//uneVueComplete.setVisible(false); 
			uneVueMedia.setVisible(true);
			uneVueTemps.setVisible(false);
			uneVueTranche.setVisible(false);
			uneVueRea.setVisible(false);
		}
		else if (e.getSource() == this.tabButton[4])
		{
			
			
			uneVueProduit.setVisible(false); 
			//uneVueComplete.setVisible(false); 
			uneVueRea.setVisible(true);
			uneVueTemps.setVisible(false);
			uneVueTranche.setVisible(false);
			uneVueMedia.setVisible(false);
		}
		
	}


}

package vue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import controleur.Administrateur;
import controleur.Main;

import modele.Modele;

public class VueConnexion extends JFrame implements ActionListener,KeyListener
{
	private JPanel unPanel = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btSeConnecter = new JButton("Se Connecter"); 
	private JTextField txtLogin = new JTextField(); 
	private JPasswordField pwdMdp = new JPasswordField();
	
	
	public VueConnexion()
	{
		this.setTitle("Connexion Admin");
		this.setBounds(200, 200, 500, 350);
		this.setLayout(null); 
		this.setResizable(false); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.getContentPane().setBackground(Color.white);
		//construction du pannel 
		this.unPanel.setBounds(50, 150, 400, 150);
		this.unPanel.setBackground(Color.lightGray); 
		this.unPanel.setLayout(new GridLayout(3,2));
		this.unPanel.add(new JLabel("Login : "));
		this.unPanel.add(this.txtLogin);
		this.unPanel.add(new JLabel("MDP : "));
		this.unPanel.add(this.pwdMdp); 
		this.unPanel.add(this.btAnnuler); 
		this.unPanel.add(this.btSeConnecter);
		
		this.unPanel.setVisible(true);
		this.add(this.unPanel);
		
		//ajout de l'image à la fenetre 
		ImageIcon logo = new ImageIcon("src/images/logo.png");
		JLabel lbLogo = new JLabel(logo); 
		lbLogo.setBounds(50, 20, 400, 120);
		this.add(lbLogo);
		
		
		//changer icone application 
		ImageIcon logopetit = new ImageIcon("src/images/icone.png"); 
		this.setIconImage(logopetit.getImage());
		
		//rendre les boutons cliquables 
		this.btAnnuler.addActionListener(this); 
		this.btSeConnecter.addActionListener(this);
		
		//rendre la touche entree ecoutable 
		this.txtLogin.addKeyListener(this);
		this.pwdMdp.addKeyListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 switch (e.getActionCommand())
		 {
		 case "Annuler" : 
			 this.txtLogin.setText("");
			 this.pwdMdp.setText("");
			 break; 
		 case "Se Connecter" : 
			 traitement();
			 break; 
		 }
		
	}
	
	private void traitement ()
	{
		 String login = this.txtLogin.getText(); 
		 String mdp = new String(this.pwdMdp.getPassword());
		 if (login.equals("") || mdp.equals(""))
		 {
			 JOptionPane.showMessageDialog(this,"Veuillez remplir les identifiants");
		 }else {
		 
				 String Nom = Modele.verifConnexion(login, mdp); 
				
				 if (Nom.equals(""))
				 {
					 JOptionPane.showMessageDialog(this, "Erreur d'identifiants",
							 "Erreur", JOptionPane.ERROR_MESSAGE);
					 this.txtLogin.setText("");
					 this.pwdMdp.setText("");
				 }else 
				 {
					 JOptionPane.showMessageDialog(this, "Bienvenue  !",
							 "Connexion réussie", JOptionPane.INFORMATION_MESSAGE);
				
					 //appel de la Jframe generale 
					 Main.rendreVisible(false);
					 
					 new VueGeneral(Nom);
					
				 }
		 }
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER)
		{
			traitement();
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}



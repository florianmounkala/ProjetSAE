import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Rapport.CreatePDF;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FenetrePrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipal frame = new FenetrePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public FenetrePrincipal() throws SQLException{
		setFont(new Font("Arial", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 677, 466);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu File = new JMenu("Fichier");
		menuBar.add(File);
		
		JMenuItem Quitter = new JMenuItem("Quitter");
		Quitter.addActionListener(this);
		File.add(Quitter);
		
		JMenu Connexion = new JMenu("Connexion");
		menuBar.add(Connexion);
		
		JMenuItem ConnexionItem = new JMenuItem("Connexion");
		Connexion.add(ConnexionItem);
		
		JMenuItem Déconnexion = new JMenuItem("D\u00E9connexion");
		Connexion.add(Déconnexion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(Color.WHITE);
		menuBar_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		contentPane.add(menuBar_1, BorderLayout.NORTH);
		
		JPanel panel_locations = new JPanel();
		panel_locations.setForeground(Color.WHITE);
		menuBar_1.add(panel_locations);
		panel_locations.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Locations");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		panel_locations.add(btnNewButton, BorderLayout.CENTER);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(3, 10));
		panel_locations.add(rigidArea_1, BorderLayout.EAST);
		
		JPanel panel_locataires = new JPanel();
		menuBar_1.add(panel_locataires);
		panel_locataires.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Locataires");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		panel_locataires.add(btnNewButton_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(3, 10));
		panel_locataires.add(rigidArea_2, BorderLayout.EAST);
		
		JPanel panel_loyer = new JPanel();
		menuBar_1.add(panel_loyer);
		panel_loyer.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_loyer.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton_8 = new JButton("Loyers");
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		panel_5.add(btnNewButton_8);
		
		JButton btnNewButton_13 = new JButton("Baux");
		btnNewButton_13.addActionListener(this);
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		panel_5.add(btnNewButton_13);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(3, 10));
		panel_loyer.add(rigidArea_3, BorderLayout.EAST);
		
		JPanel panel_charges = new JPanel();
		menuBar_1.add(panel_charges);
		panel_charges.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_4 = new JButton("Gestion des charges");
		btnNewButton_4.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		btnNewButton_4.setBackground(Color.WHITE);
		panel_charges.add(btnNewButton_4);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(3, 10));
		panel_charges.add(rigidArea_4, BorderLayout.EAST);
		
		JPanel panel_documents = new JPanel();
		menuBar_1.add(panel_documents);
		panel_documents.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_5 = new JButton("Factures");
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		btnNewButton_5.setBackground(Color.WHITE);
		panel_documents.add(btnNewButton_5);
		
		Component rigidArea = Box.createRigidArea(new Dimension(0, 50));
		menuBar_1.add(rigidArea);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 3, 10, 10));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 10, 10));
		
		JButton btnNewButton_11 = new JButton("Statistiques");
		btnNewButton_11.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		btnNewButton_11.setBackground(new Color(204, 255, 255));
		panel_4.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Administratif");
		btnNewButton_12.addActionListener(this);
		btnNewButton_12.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		btnNewButton_12.setBackground(new Color(204, 255, 255));
		panel_4.add(btnNewButton_12);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 10, 10));
		
		JButton Loyer_en_cours = new JButton("Loyer en cours");
		Loyer_en_cours.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		Loyer_en_cours.setBackground(new Color(204, 255, 255));
		panel_1.add(Loyer_en_cours);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnNewButton_6 = new JButton("R\u00E9gularisation");
		btnNewButton_6.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		btnNewButton_6.setBackground(new Color(204, 255, 255));
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Revenus");
		btnNewButton_7.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		btnNewButton_7.setBackground(new Color(204, 255, 255));
		panel_2.add(btnNewButton_7);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 10, 10));
		
		JButton btnNewButton_9 = new JButton("Travaux d\u00E9ductibles");
		btnNewButton_9.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		btnNewButton_9.setBackground(new Color(204, 255, 255));
		panel_3.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton(" Ajouter un solde de tout compte");
		btnNewButton_10.addActionListener(this);
		btnNewButton_10.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		btnNewButton_10.setBackground(new Color(204, 255, 255));
		panel_3.add(btnNewButton_10);
	}
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String requete = "SELECT RÉFÉRENCE, REFERENCE_DU_PAIEMENT, DATE_FACTURE, DATE_DE_PAIEMENT, TYPE_DE_PAIEMENT , ID_TYPE_FACTURE ,PRIX ,DESCRIPTION_F FROM SAE_Facture ";
		switch(button.getText()) {
			case "Locataires":
				FenetreLocataires FenLocataires;
				try {
					FenLocataires = new FenetreLocataires();
					FenLocataires.setVisible(true);
					FenLocataires.toFront();
					break;
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			
			case "Locations":
				FenetreLocations FenLocations;
				try {
					FenLocations = new FenetreLocations();
					FenLocations.setVisible(true);
					FenLocations.toFront();
					break;
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
			case "Factures":
				FenetreFacture FenFac;
				try {
					FenFac = new FenetreFacture(requete);
					FenFac.setVisible(true);
					FenFac.toFront();
					this.dispose();
					break;
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			case " Ajouter un solde de tout compte":
				Ajouter_solde_tout_compte x ;
				x = new Ajouter_solde_tout_compte();
				x.setVisible(true);
				x.toFront();
				this.dispose();
				break;
		}

		
	}
}
